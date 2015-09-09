public class Main {

    public static void main(String[] args) {
        System.out.println("This program gives you the ticket price for"
        		+ "a flight from one state to another.");
        System.out.println("What is the abbreviation for the first state?");
        
        Location location1 = new Location("CA");
        System.out.println(location1.zoneToString());
    }

}