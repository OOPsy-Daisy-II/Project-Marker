//816030997
package oopsy_daisy.SampleAssignment; 

import java.time.LocalDateTime;

/**
 * Write a description of class Flight here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flight
{
    private String flightNo;
    private String destination;
    private String origin;
    private LocalDateTime flightDate;
    private LuggageManifest manifest;
    
    /**
     * Constructor for objects of class Flight
     */
    public Flight(String flightNo, String destination, String origin, LocalDateTime flightDate)
    {
        setFlightNo(flightNo);
        setDestination(destination);
        setOrigin(origin);
        setFlightDate(flightDate);
        setManifest(new LuggageManifest());
    }
    
    public String getFlightNo(){
        return flightNo;
    }
    
    public String getDestination(){
        return destination;
    }
    
    public String getOrigin(){
        return origin;
    }
    
    public LocalDateTime getFlightDate(){
        return flightDate;
    }
    
    public LuggageManifest getManifest(){
        return manifest;
    }
    
    private void setFlightNo(String flightNo){
        this.flightNo = flightNo;
    }
    
    private void setDestination(String destination){
        this.destination = destination;
    }
    
    private void setOrigin(String origin){
        this.origin = origin;
    }
    
    private void setFlightDate(LocalDateTime flightDate){
        this.flightDate = flightDate;
    }
    
    private void setManifest(LuggageManifest manifest){
        this.manifest = manifest;
    }
    
    public String checkInLuggage(Passenger p){
        if (p.getFlightNo().equals(this.getFlightNo()))
            return getManifest().addLuggage(p, this);
        
        return "Invalid flight";
    }
    
    public String printLuggageManifest(){
        return getManifest().toString();
    }
    
    public static int getAllowedLuggage(char cabinClass){
        if (cabinClass == 'F')
            return 3;
        else if (cabinClass == 'B')
            return 2;
        else if (cabinClass == 'P')
            return 1;
        else if (cabinClass == 'E')
            return 0;
        
        return -1;
    }
    
    public String toString(){
        return getFlightNo() + " DESTINATION: " + getDestination() + " ORIGIN: " + getOrigin() + " " + getFlightDate().toString();
    }
}
