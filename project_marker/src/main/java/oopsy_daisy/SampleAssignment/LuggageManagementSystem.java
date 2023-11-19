//816030997
package oopsy_daisy.SampleAssignment;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class LuggageManagementSystem
{
    public static void main(String[] args){
        LocalDateTime d = LocalDateTime.of(2023,1,23,10, 00, 00);
        Random rand = new Random();
        
        ArrayList<Flight> flights = new ArrayList<Flight>();
        String flightNo;
        String destination;
        String origin;
        
        
        try
        {
            Scanner s = new Scanner(new File("FlightList.txt"));
            
            String line;
            String[] parts;
            
            while(s.hasNext()){
                line = s.nextLine();
                parts = line.split(" ");
                
                flightNo = parts[0];
                destination = parts[1];
                origin = parts[2];
                
                Flight f = new Flight(flightNo, destination, origin, d);
                flights.add(f);
                System.out.println(f);
            }
            
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println();
        
        String passportNumber;
        String firstName;
        String lastName;
        
        try
        {
            Scanner s = new Scanner(new File("PassengerList.txt"));
            
            String line;
            String[] parts;
            
            while(s.hasNext()){
                line = s.nextLine();
                parts = line.split(" ");
                
                passportNumber = parts[0];
                firstName = parts[1];
                lastName = parts[2];
                
                Flight f = flights.get(rand.nextInt(flights.size()));
                Passenger p = new Passenger(passportNumber, firstName, lastName, f.getFlightNo());
                System.out.println(p);
                System.out.println();
                System.out.println(f.checkInLuggage(p));
                System.out.println();
            }
            
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        System.out.println();
        
        for (Flight f: flights){
            System.out.println(f);
            System.out.println(f.printLuggageManifest());
        }
        
    }
}
