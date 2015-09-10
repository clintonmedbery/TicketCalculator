import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
    	InputStreamReader input = new InputStreamReader(System.in);
    	BufferedReader reader = new BufferedReader(input);
    	
        System.out.println("This program gives you the ticket price for"
        		+ "a flight from one state to another.");
        System.out.println("What is the abbreviation for the departure state?");

        try {
			String departureState = reader.readLine();
	        System.out.println("What is the abbreviation for the destination state?");
			String destinationState = reader.readLine();
			Location departure = new Location(departureState);
			Location destination = new Location(destinationState);
	        System.out.println("Departure Zone");
	        System.out.println(departure.zoneToString());

	        System.out.println("Destination Zone");
	        System.out.println(destination.zoneToString());

			System.out.println(departure.getFlightCost(destination));
		} catch (IOException e) {
			System.out.println(e);
		}
        
        
    }

}