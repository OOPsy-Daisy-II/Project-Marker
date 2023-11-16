import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PassengerTest {

  @Test
  void testConstructor() {
    Passenger p = new Passenger("1234", "John", "Doe", "AA101");
    assertNotNull(p.getPassportNumber());
    assertNotNull(p.getFirstName());
    assertNotNull(p.getLastName());
    assertNotNull(p.getFlightNo());
    assertNotNull(p.getCabinClass());
    assertTrue(p.getNumLuggage() >= 0); 
  }

  @Test
  void testAssignRandomCabinClass() {
    Passenger p = new Passenger("1234", "John", "Doe", "AA101");
    p.assignRandomCabinClass();
    char cabinClass = p.getCabinClass();
    assertTrue(cabinClass == 'F' || cabinClass == 'B' || cabinClass == 'P' || cabinClass == 'E');
  }

  @Test
  void testToString() {
    Passenger p = new Passenger("1234", "John", "Doe", "AA101");
    String expected = "PP NO: 1234 NAME: JohnDoe NUMLUGGAGE: " + p.getNumLuggage() + " CLASS: " + p.getCabinClass();
    assertEquals(expected, p.toString());
  }

}