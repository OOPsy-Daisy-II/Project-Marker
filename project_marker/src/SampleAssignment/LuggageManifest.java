//816030997
import java.util.ArrayList;

/**
 * Write a description of class LuggageManifest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LuggageManifest
{

    private ArrayList<LuggageSlip> slips;

    /**
     * Constructor for objects of class LuggageManifest
     */
    public LuggageManifest()
    {
        slips = new ArrayList<LuggageSlip>();
    }
    
    public String addLuggage(Passenger p, Flight f){
        if (!p.getFlightNo().equals(f.getFlightNo()))
            return "Invalid flight";
        
        int numAllowedPieces = Flight.getAllowedLuggage(p.getCabinClass());
        double excessLuggageCost = getExcessLuggageCost(p.getNumLuggage(), numAllowedPieces);
        String label = "$" + excessLuggageCost;
        int numPieces = p.getNumLuggage();
        
        for (int i = 0; i < numPieces; i++){
            LuggageSlip ls = new LuggageSlip(p, f);
            ls.setLabel(label);
            getSlips().add(ls);
        }
        
        if (numPieces == 0)
            return p.toString() + "\nNo Luggage to add.";
        
        return p.toString() + "\nPieces Added: (" + numPieces + "). Excess Cost: " + label;
    }
    
    public double getExcessLuggageCost(int numPieces, int numAllowedPieces){
        if (numPieces > numAllowedPieces)
            return (numPieces - numAllowedPieces) * 35.00;
        
        return 0;
    }
    
    public String getExcessLuggageCostByPassenger(String passportNumber){
        int numPieces = 0;
        int numAllowedPieces = 0;
        double excessLuggageCost;
        
        for (LuggageSlip ls: getSlips()){
            if (passportNumber.equals(ls.getOwner().getPassportNumber())){
                numAllowedPieces = Flight.getAllowedLuggage(ls.getOwner().getCabinClass());
                numPieces++;
            }
        }
        
        
        if (numPieces > 0){
            excessLuggageCost = getExcessLuggageCost(numPieces, numAllowedPieces);
            return "$" + excessLuggageCost;
        }
        
        return "No Cost";
    }
    
    public ArrayList<LuggageSlip> getSlips(){
        return slips;
    }
    
    public String toString(){
        String s = "LUGGAGE MANIFEST:\n";
        for (LuggageSlip ls: getSlips())
            s = s + ls.toString() + "\n";
        
        return s;
    }
}
