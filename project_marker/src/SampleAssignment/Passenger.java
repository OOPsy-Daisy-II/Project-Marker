//816030997
import java.util.Random;

/**
 * Write a description of class Passenger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Passenger{
    private String passportNumber;
    private String flightNo;
    private String firstName;
    private String lastName;
    private int numLuggage;
    private char cabinClass;
    
    public String getPassportNumber(){
        return passportNumber;
    }
    
    public String getFlightNo(){
        return flightNo;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public int getNumLuggage(){
        return numLuggage;
    }
    
    public char getCabinClass(){
        return cabinClass;
    }
    
    private void setPassportNumber(String passportNumber){
        this.passportNumber = passportNumber;
    }
    
    private void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    private void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    private void setFlightNo(String flightNo){
        this.flightNo = flightNo;
    }
    
    public void setNumLuggage(int numLuggage){
        this.numLuggage = numLuggage;
    }
    
    private void setCabinClass(char cabinClass){
        this.cabinClass = cabinClass;
    }
    

    /**
     * Constructor for objects of class Passenger
     */
    public Passenger(String passportNumber, String firstName, String lastName, String flightNo){
        setPassportNumber(passportNumber);
        setFirstName(firstName);
        setLastName(lastName);
        setFlightNo(flightNo);
        assignRandomCabinClass();
        assignRandomNumLuggage();
    }

    private void assignRandomCabinClass(){
        char[] s = {'F', 'B', 'P', 'E'};
        Random rand = new Random();
        setCabinClass(s[rand.nextInt(4)]);
    }

    private void assignRandomNumLuggage(){
        Random rand = new Random();
        setNumLuggage(rand.nextInt(11));
    }
    
    public String toString(){
        String nameCaps = getFirstName().toUpperCase().charAt(0) + "." + getLastName().toUpperCase();
        return "PP NO. " + getPassportNumber() + " NAME: " + nameCaps + " NUMLUGGAGE: " + getNumLuggage() + " CLASS: " + getCabinClass();
    }
}
