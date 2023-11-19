//816030997
package oopsy_daisy.SampleAssignment; 
/**
 * Write a description of class LuggageSlip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LuggageSlip{
    
    private Passenger owner;
    private static int luggageSlipIDCounter = 1;
    private String luggageSlipID;
    private String label;
    private Flight flight;
    
    public Passenger getOwner(){
        return owner;
    }
    
    public int getLuggageSlipIDCounter(){
        return luggageSlipIDCounter;
    }
    
    public String getLuggageSlipID(){
        return luggageSlipID;
    }
    
    public String getLabel(){
        return label;
    }
    
    public Flight getFlight(){
        return flight;
    }
    
    private void setOwner(Passenger owner){
        this.owner = owner;
    }
    
    private void setLuggageSlipIDCounter(){
        luggageSlipIDCounter++;
    }
    
    private void setLuggageSlipID(){
        this.luggageSlipID = owner.getFlightNo() + "_" + owner.getLastName() + "_" + getLuggageSlipIDCounter();
        setLuggageSlipIDCounter();
    }
    
    public void setLabel(String label){
        this.label = label;
    }
    
    public void setFlight(Flight flight){
        this.flight = flight;
    }
    
    
    /**
     * Constructor for objects of class LuggageSlip
     */
    public LuggageSlip(Passenger p, Flight f){
        setOwner(p);
        setFlight(f);
        setLuggageSlipID();
        setLabel("");
    }
    
    public LuggageSlip(Passenger p, Flight f, String label){
        setOwner(p);
        setFlight(f);
        setLuggageSlipID();
        setLabel(label);
    }
    
    public boolean hasOwner(String passportNumber){
        return getOwner().getPassportNumber().equals(passportNumber);
    }
    
    public String toString(){
        return getLuggageSlipID() + " " + getOwner().toString() + " " + getLabel();
    }
}
