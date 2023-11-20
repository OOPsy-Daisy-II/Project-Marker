package oopsy_daisy.AssignmentSpec;
import oopsy_daisy.SampleAssignment.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;

public class LuggageManifestTest extends BaseTest{

  static int totalScore = 0;
  
  Passenger passenger1;
  Passenger passenger2;
  Flight flight;
  LuggageManifest manifest;

  @Before
  public void setUp() {
    passenger1 = new Passenger("TA890789", "Joe", "Bean", "BW600");
    passenger2 = new Passenger("BA321963", "Lucy", "Deer", "BW600");
    LocalDateTime d = LocalDateTime.of(2023, 1, 23, 10, 00, 00);
    flight = new Flight("BW600", "POS", "YYZ", d);
    manifest = new LuggageManifest();
  }

  @Test
  public void testConstructor() {
    assertEquals(0, manifest.getSlips().size());
    
    totalScore += 1; // Award mark for constructor test
  }

  @Test
  public void testAttributes() {

  LuggageManifest manifest = new LuggageManifest();
  
  // Test slips
  assertNotNull(manifest.getSlips()); 
  assertTrue(manifest.getSlips() instanceof ArrayList);
  assertEquals(0, manifest.getSlips().size());
  totalScore += 2;

}

  @Test
  public void testAddLuggage() {
    manifest.addLuggage(passenger1, flight);
    assertEquals(2, manifest.getSlips().size());

    manifest.addLuggage(passenger2, flight);
    assertEquals(4, manifest.getSlips().size());
    
    totalScore += 6; // Award totalScore for addLuggage test
  }

  @Test
  public void testGetExcessLuggageCost() {
    double cost1 = manifest.getExcessLuggageCost(3, 2);
    assertEquals(35.0, cost1, 0.001);
    
    double cost2 = manifest.getExcessLuggageCost(1, 2);
    assertEquals(0.0, cost2, 0.001);
    
    totalScore += 3; // Award totalScore for getExcessLuggageCost test
  }

  @Test
  public void testGetExcessLuggageCostByPassenger() {
    manifest.addLuggage(passenger1, flight);
    assertEquals("0", manifest.getExcessLuggageCostByPassenger("TA890789"));
    
    manifest.addLuggage(passenger2, flight);
    assertEquals("35", manifest.getExcessLuggageCostByPassenger("BA321963"));

    totalScore += 5; // Award totalScore for getExcessLuggageCostByPassenger test
  }

  @Test
public void testToString() {

  // Create passengers
  Passenger passenger1 = new Passenger("PP1", "John", "Doe", "BW100");
  Passenger passenger2 = new Passenger("PP2", "Jane", "Doe", "BW100");

  // Create flight 
  Flight flight = new Flight("BW100", "LHR", "JFK", LocalDateTime.now());

  // Create manifest and add luggage
  LuggageManifest manifest = new LuggageManifest();
  manifest.addLuggage(passenger1, flight); 
  manifest.addLuggage(passenger2, flight);

  // Expected string
  String expected = "BW100_Doe_1 PP NO. PP1 NAME: JohnDoe NUMLUGGAGE: 1 CLASS: E\n" +
                    "BW100_Doe_2 PP NO. PP2 NAME: JaneDoe NUMLUGGAGE: 1 CLASS: E\n";
  
  // Test toString
  String actual = manifest.toString();
  assertEquals(expected, actual);

  // Verify passenger and flight details
  assertTrue(actual.contains("PP1"));
  assertTrue(actual.contains("JohnDoe"));
  assertTrue(actual.contains("PP2")); 
  assertTrue(actual.contains("JaneDoe"));
  assertTrue(actual.contains("BW100"));

  // Award marks
  totalScore += 3;

}

  @AfterClass
  public static void printTotal() {
    System.out.println("LuggageManifestTest Total Score: " + totalScore);
    finalScore += totalScore;
  }
  
  @Override
  public int test() {
    
    return totalScore;
}
}
