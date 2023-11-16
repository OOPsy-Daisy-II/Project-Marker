import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;

class LuggageSlipTest {

  Passenger passenger;
  Flight flight;
  
  @BeforeEach
  void setUp() {
    passenger = new Passenger("TA890789", "Joe", "Bean", "BW600"); 
    flight = new Flight("BW600"); 
  }

  @Test
  void testConstructorWithoutLabel() {
    LuggageSlip slip = new LuggageSlip(passenger, flight);
    
    assertEquals(passenger, slip.getOwner());
    assertTrue(slip.getLuggageSlipID().contains("BW600"));
    assertTrue(slip.getLuggageSlipID().contains("Bean"));
    assertEquals("", slip.getLabel());
  }
  
  @Test
  void testConstructorWithLabel() {
    LuggageSlip slip = new LuggageSlip(passenger, flight, "$105");
    
    assertEquals("$105", slip.getLabel());
  }

  @Test
  void testHasOwner() {
    LuggageSlip slip = new LuggageSlip(passenger, flight);
    
    assertTrue(slip.hasOwner("TA890789"));
    assertFalse(slip.hasOwner("XXXXXXX"));
  }

  @Test
  void testToString() {
    LuggageSlip slip = new LuggageSlip(passenger, flight, "$105");

    String expected = slip.getLuggageSlipID() + " PP NO. TA890789 NAME: JoeBean " 
                    + "NUMLUGGAGE: " + passenger.getNumLuggage() 
                    + " CLASS: " + passenger.getCabinClass() + " $105";
    
    assertEquals(expected, slip.toString());
  }

}