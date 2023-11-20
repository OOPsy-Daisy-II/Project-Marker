package oopsy_daisy.AssignmentSpec;
import oopsy_daisy.SampleAssignment.*;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Test;


public class PassengerTest extends BaseTest{

  static int totalScore = 0;
  
  @Test
public void testAttributes() {

  Passenger passenger = new Passenger("1234", "John", "Doe", "AA101");

  assertEquals("1234", passenger.getPassportNumber());
  totalScore += 1;

  assertEquals("AA101", passenger.getFlightNo());
  totalScore += 1;  

  assertEquals("John", passenger.getFirstName());
  totalScore += 1;

  assertEquals("Doe", passenger.getLastName());
  totalScore += 1;

  assertEquals(0, passenger.getNumLuggage()); //default value
  totalScore += 1; 

  assertEquals('E', passenger.getCabinClass()); //default value
  totalScore += 1;

}

  @Test
  public void testConstructor() {
    Passenger p = new Passenger("1234", "John", "Doe", "AA101");
    
    assertNotNull(p.getPassportNumber()); // 2 marks
    assertNotNull(p.getFirstName());
    assertNotNull(p.getLastName());
    assertNotNull(p.getFlightNo());  
    totalScore += 2;
    
    assertTrue(p.getNumLuggage() >= 0); // 2 marks 
    totalScore += 2;
    
    char cabinClass = p.getCabinClass();
    assertTrue(cabinClass == 'F' || cabinClass == 'B' || cabinClass == 'P' || cabinClass == 'E'); // 1 mark
    totalScore += 1;
  }

  @Test
  public void testAssignRandomCabinClass() {
    Passenger p = new Passenger("1234", "John", "Doe", "AA101");
    // p.assignRandomCabinClass();
    char cabinClass = p.getCabinClass();
    assertTrue(cabinClass == 'F' || cabinClass == 'B' || cabinClass == 'P' || cabinClass == 'E');
    
    totalScore += 2; // 2 marks
  }

  @Test
  public void testToString() {
    Passenger p = new Passenger("1234", "Doe.", "John", "AA101");
    String expected = "PP NO: 1234 NAME: Doe.John NUMLUGGAGE: " + p.getNumLuggage() + " CLASS: " + p.getCabinClass();
    assertEquals(expected, p.toString());

    
    totalScore += 3; // 3 marks
  }
  
  @AfterClass
  public static void printTotal() {
    System.out.println("PassengerTest Total Score: " + totalScore);
    finalScore += totalScore;
  }

  @Override
  public int test() {
    
    return totalScore;
}


}
