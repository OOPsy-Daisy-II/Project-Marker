import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LuggageManifestTest {

  Passenger passenger1;
  Passenger passenger2;
  Flight flight;
  LuggageManifest manifest;

  @BeforeEach
  void setUp() {
    passenger1 = new Passenger("TA890789", "Joe", "Bean", "BW600");
    passenger2 = new Passenger("BA321963", "Lucy", "Deer", "BW600");
    flight = new Flight("BW600");
    manifest = new LuggageManifest();
  }

  @Test
  void testConstructor() {
    assertEquals(0, manifest.getSlips().size()); 
  }

  @Test
  void testAddLuggage() {
    manifest.addLuggage(passenger1, flight);
    assertEquals(2, manifest.getSlips().size());

    manifest.addLuggage(passenger2, flight);
    assertEquals(4, manifest.getSlips().size());
  }

  @Test
  void testGetExcessLuggageCost() {
    double cost1 = manifest.getExcessLuggageCost(3, 2);
    assertEquals(35.0, cost1);
    
    double cost2 = manifest.getExcessLuggageCost(1, 2);
    assertEquals(0.0, cost2);
  }

  @Test
  void testGetExcessLuggageCostByPassenger() {
    manifest.addLuggage(passenger1, flight);
    assertEquals("0", manifest.getExcessLuggageCostByPassenger("TA890789", 0));
    
    manifest.addLuggage(passenger2, flight);
    assertEquals("35", manifest.getExcessLuggageCostByPassenger("BA321963", 35));
  }

  @Test
  void testToString() {
    manifest.addLuggage(passenger1, flight);
    manifest.addLuggage(passenger2, flight);
    
    String expected = "BW600_Bean_1 PP NO. TA890789 NAME: JoeBean NUMLUGGAGE: 2 CLASS: F\n" +
                      "BW600_Bean_2 PP NO. TA890789 NAME: JoeBean NUMLUGGAGE: 2 CLASS: F\n" +
                      "BW600_Deer_3 PP NO. BA321963 NAME: LucyDeer NUMLUGGAGE: 2 CLASS: P $35\n" + 
                      "BW600_Deer_4 PP NO. BA321963 NAME: LucyDeer NUMLUGGAGE: 2 CLASS: P $35\n";

    assertEquals(expected, manifest.toString());
  }

}