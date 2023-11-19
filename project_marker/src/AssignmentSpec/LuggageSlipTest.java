package oopsy_daisy;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class LuggageSlipTest {

  static int totalScore = 0;
  
  Passenger passenger;
  Flight flight;
  
  @Before
  public void setUp() {
    passenger = new Passenger("TA890789", "Joe", "Bean", "BW600");
    LocalDateTime d = LocalDateTime.of(2023, 1, 23, 10, 00, 00);
    flight = new Flight("BW600", "POS", "YYZ", d);
  }

  @Test
  public void testConstructorWithoutLabel() {
    LuggageSlip slip = new LuggageSlip(passenger, flight);
    
    assertEquals(passenger, slip.getOwner());
    assertTrue(slip.getLuggageSlipID().contains("BW600"));
    assertTrue(slip.getLuggageSlipID().contains("Bean"));
    assertEquals("", slip.getLabel());
    
    totalScore += 3; // Award totalScore for default constructor test
  }
  
  @Test
  public void testConstructorWithLabel() {
    LuggageSlip slip = new LuggageSlip(passenger, flight, "$105");
    
    assertEquals("$105", slip.getLabel());
    
    totalScore += 3; // Award totalScore for overloaded constructor test
  }

  @Test
  public void testAttributes() {

  // Create test data
  Passenger passenger = new Passenger("1234", "John", "Doe", "AA101");
  Flight flight = new Flight("AA101", "LHR", "JFK", LocalDateTime.now());
  
  // Test owner
  LuggageSlip slip = new LuggageSlip(passenger, flight);
  assertEquals(passenger, slip.getOwner());
  totalScore += 1;  

  // Test counter
  assertEquals(1, LuggageSlip.getLuggageSlipIDCounter());
  totalScore += 1;

  // Test ID
  String expectedID = "AA101_Doe_1"; 
  assertEquals(expectedID, slip.getLuggageSlipID());
  totalScore += 1;

  // Test label
  assertEquals("", slip.getLabel());
  totalScore += 1;

  // Test constructor sets label
  LuggageSlip slip2 = new LuggageSlip(passenger, flight, "$105");
  assertEquals("$105", slip2.getLabel()); 
  totalScore += 1;
  
}

  @Test
  public void testHasOwner() {
    LuggageSlip slip = new LuggageSlip(passenger, flight);
    
    assertTrue(slip.hasOwner("TA890789"));
    assertFalse(slip.hasOwner("XXXXXXX"));
    
    totalScore += 2; // Award totalScore for hasOwner test
  }

  @Test
  public void testToString() {
    LuggageSlip slip = new LuggageSlip(passenger, flight, "$105");

    String expected = slip.getLuggageSlipID() + " PP NO. TA890789 NAME: JoeBean "
                    + "NUMLUGGAGE: " + passenger.getNumLuggage()
                    + " CLASS: " + passenger.getCabinClass() + " $105";
    
    assertEquals(expected, slip.toString());
    
    totalScore += 2; // Award totalScore for toString test
  }

  @AfterClass
  public static void printTotal() {
    System.out.println("Total Score: " + totalScore);
  }


}
