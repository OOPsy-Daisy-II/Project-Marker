package oopsy_daisy.AssignmentSpec;

import oopsy_daisy.SampleAssignment.*;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;




public class FlightTest {

  public static int totalScore = 0;

  Flight flight;
  Passenger passenger;

  @Before
  public void setUp() {
    flight = new Flight("BW600", "POS", "YYZ", LocalDateTime.of(2023, 1, 23, 10, 0));
    passenger = new Passenger("1234", "John", "Doe", "BW600");
  }

  @Test
  public void testConstructor() {
    assertEquals("BW600", flight.getFlightNo());
    assertEquals("POS", flight.getDestination());
    assertEquals("YYZ", flight.getOrigin());
    assertEquals(LocalDateTime.of(2023, 1, 23, 10, 0), flight.getFlightDate());
    
    totalScore += 2; // Award totalScore for constructor test
  }

  @Test
public void testAttributes() {

  // Test flight number
  Flight flight = new Flight("BW101", "LHR", "JFK", LocalDateTime.now());
  assertEquals("BW101", flight.getFlightNo());
  totalScore += 1;

  // Test destination
  assertEquals("LHR", flight.getDestination()); 
  totalScore += 1;

  // Test origin
  assertEquals("JFK", flight.getOrigin());
  totalScore += 1;

  // Test flight date
  LocalDateTime expectedDate = LocalDateTime.now();
  assertEquals(expectedDate, flight.getFlightDate());
  totalScore += 1;

  // Test manifest
  assertNotNull(flight.getManifest());
  assertTrue(flight.getManifest() instanceof LuggageManifest);
  totalScore += 1;


}
@Test
public void testCheckInLuggage() {

  // Create test data
  Flight flight = new Flight("AA101", "LHR", "JFK", LocalDateTime.now());
  Passenger passenger = new Passenger("1234", "John", "Doe", "AA101");

  // Check in passenger luggage
  String result = flight.checkInLuggage(passenger);

  // Validate luggage added
  assertEquals(1, flight.getManifest().getSlips().size());

  // Check result message
  String expected = "PP NO. 1234 NAME: JohnDoe NUMLUGGAGE: 1 CLASS: E Pieces Added: (1) Excess Cost: $0";
  assertEquals(expected, result);

  // Check invalid flight
  Passenger passenger2 = new Passenger("5678", "Jane", "Doe", "AA102");
  String invalidResult = flight.checkInLuggage(passenger2);
  assertEquals("Invalid flight", invalidResult);

  // Award totalScore 
  totalScore += 5;

}

@Test  
public void testPrintLuggageManifest() {

  // Check in passenger
  Flight flight = new Flight("AA101", "LHR", "JFK", LocalDateTime.now());
  Passenger passenger = new Passenger("1234", "John", "Doe", "AA101");
  flight.checkInLuggage(passenger);

  // Print manifest
  String printed = flight.printLuggageManifest();

  // Verify output
  assertEquals(flight.getManifest().toString(), printed);

  // Award totalScore
  totalScore += 1;

}

  @Test
  public void testGetAllowedLuggage() {
    assertEquals(3, flight.getAllowedLuggage('F'));
    assertEquals(2, flight.getAllowedLuggage('B'));
    assertEquals(1, flight.getAllowedLuggage('P'));
    assertEquals(0, flight.getAllowedLuggage('E'));
    
    totalScore += 2; // Award totalScore for getAllowedLuggage
  }

  @Test
  public void testToString() {
    String expected = "BW600 DESTINATION: POS ORIGIN:YYZ 2023-01-23T10:00\n";
    assertEquals(expected, flight.toString());
    
    totalScore += 1; // Award mark for toString test
  }

  @AfterClass
  public static void printTotal() {
    System.out.println("Total Score: " + totalScore);
  }

}