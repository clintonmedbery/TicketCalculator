import java.math.BigDecimal;

public class Location {
	private Zone zone;
	private String state;
	
	public Location(String state) {
		this.setState(state.toUpperCase());
	
		if(state.equals("WA") || state.equals("OR") || state.equals("CA") || state.equals("NV") || state.equals("AZ")) {
			zone = Zone.Zone6;
		} else if(state.equals("ID") || state.equals("UT") || state.equals("MT") || state.equals("WY") 
				|| state.equals("ND") || state.equals("SD") || state.equals("CO")) {
			zone = Zone.Zone5;
		} else if(state.equals("NM") || state.equals("OK") || state.equals("TX") || state.equals("AR") 
				|| state.equals("LA")) {
			zone = Zone.Zone4;
		} else if(state.equals("NE") || state.equals("KS") || state.equals("MN") || state.equals("IA") 
				|| state.equals("MO") || state.equals("WI") || state.equals("IL") || state.equals("MI")
				|| state.equals("IN") || state.equals("KY") || state.equals("OH")) {
			zone = Zone.Zone3;
		} else if(state.equals("WV") || state.equals("VA") || state.equals("MD") || state.equals("DE") 
				|| state.equals("PA") || state.equals("NY") || state.equals("MA") || state.equals("NH")
				|| state.equals("ME")) {
			zone = Zone.Zone2;
		} else if(state.equals("TN") || state.equals("MS") || state.equals("AL") || state.equals("GA") 
				|| state.equals("SC") || state.equals("NC") || state.equals("FL")) {
			zone = Zone.Zone1;
		}
	}
	
	public String zoneToString(){
		
		switch(this.zone){
			case Zone1:
				return "Zone 1";
			case Zone2:
				return "Zone 2";
			case Zone3:
				return "Zone 3";
			case Zone4:
				return "Zone 4";
			case Zone5:
				return "Zone 5";
			case Zone6:
				return "Zone 6";
			default:
				return "No Zone";
		}
	}
	
	public BigDecimal getFlightCost(Location destination){
		
		if(this.zone == destination.zone){
			return new BigDecimal(238.00);
			
		} else if ((this.zone == Zone.Zone5 && this.zone == Zone.Zone6) ||
				(this.zone == Zone.Zone6 && this.zone == Zone.Zone5)){
			return new BigDecimal(238.00);
			
		} else if ((this.zone == Zone.Zone1) || (this.zone == Zone.Zone2) || (this.zone == Zone.Zone3)){
			if((destination.zone == Zone.Zone1) || (destination.zone == Zone.Zone2) || (destination.zone == Zone.Zone3)){
				return new BigDecimal(278.00);
				
			} else if (destination.zone == Zone.Zone4){
				return new BigDecimal(318.00);
			}
			
		} else if((this.zone == Zone.Zone4) && (destination.zone == Zone.Zone1 ||
				destination.zone == Zone.Zone2 || destination.zone == Zone.Zone3)) {
			return new BigDecimal(318.00);

		} else if((this.zone == Zone.Zone1) || (this.zone == Zone.Zone2) || (this.zone == Zone.Zone3)
				|| (this.zone == Zone.Zone4) && ((destination.zone == Zone.Zone5) || (destination.zone == Zone.Zone6))){
			return new BigDecimal(398.00);

		} else if((destination.zone == Zone.Zone1) || (destination.zone == Zone.Zone2) || (destination.zone == Zone.Zone3)
				|| (destination.zone == Zone.Zone4) && ((this.zone == Zone.Zone5) || (this.zone == Zone.Zone6))){
			return new BigDecimal(398.00);

		} 
		
		return new BigDecimal(-1);
		
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public enum Zone {
		Zone1, Zone2, Zone3, Zone4, Zone5, Zone6
	}
}



