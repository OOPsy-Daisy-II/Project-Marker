
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightTest {

  Flight flight;
  Passenger passenger;

  @BeforeEach
  void setUp() {
    flight = new Flight("BW600", "POS", "YYZ", LocalDateTime.of(2023, 1, 23, 10, 0));
    passenger = new Passenger("1234", "John", "Doe", "BW600"); 
  }

  @Test
  void testConstructor() {
    assertEquals("BW600", flight.getFlightNo());
    assertEquals("POS", flight.getDestination());
    assertEquals("YYZ", flight.getOrigin());
    assertEquals(LocalDateTime.of(2023, 1, 23, 10, 0), flight.getFlightDate());
  }

  @Test
  void testCheckInLuggage() {
    String expected = "PP NO. 1234 NAME: JohnDoe NUMLUGGAGE: "+ passenger.getNumLuggage();
    expected += " CLASS: " + passenger.getCabinClass() + " Pieces Added: (";
    expected += passenger.getNumLuggage() + ") Excess Cost: $0\n";
    
    assertEquals(expected, flight.checkInLuggage(passenger));
  }

  @Test
  void testPrintLuggageManifest() {
    flight.checkInLuggage(passenger);
    String expected = flight.getManifest().toString();
    assertEquals(expected, flight.printLuggageManifest());
  }

  @Test
  void testGetAllowedLuggage() {
    assertEquals(3, flight.getAllowedLuggage('F'));
    assertEquals(2, flight.getAllowedLuggage('B'));
    assertEquals(1, flight.getAllowedLuggage('P'));
    assertEquals(0, flight.getAllowedLuggage('E'));
  }

  @Test
  void testToString() {
    String expected = "BW600 DESTINATION: POS ORIGIN:YYZ 2023-01-23T10:00\n";
    assertEquals(expected, flight.toString());
  }

}