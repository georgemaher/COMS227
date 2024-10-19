package hw1;

public class ParkingRateUtil
{
	public static final int EXIT_TIME_LIMIT = 15;  
	private static double cost ;// cost of specific time window
	private static int days; // number of days 
	
	/**
	 * Constructs a new parking rate 
	 * doesn't take any parameters 
	 */
	private  ParkingRateUtil() {
	}
	
	/** Calculate the cost of a specific time window based on the MU rates table
	 * 
	 * @param minutes time parameter on which cost will be calculated
	 * @return the cost of the specific time
	 */
	public static double calculateCost(int minutes) {
	cost = 0;
	days = (minutes / 60) / 24;
	int minutesLeft = minutes - (days * 24 * 60);
	
	if (minutes <= 30) { // there is an if statement for each case
		cost = 1;
	}
//	else if (minutes > 30 && minutes <= 60) {
//		cost = 2;
//	}
	else if (minutes > 60 && minutes <= 120) {
		cost = 3.50;
	}

	else if (minutes > 120 && minutes <= 180) {
		cost = 5;
	}

	else if (minutes > 180 && minutes <= 240) {
		cost = 6.50;
	}

	else if (minutes > 240 && minutes <= 300) {
		cost = 8.0;
	}

	else if (minutes > 300 && minutes <= 360) {
		cost = 9.25;
	}

	else if (minutes > 360 && minutes <= 420) {
		cost = 10.50;
	}

	else if (minutes > 420 && minutes <= 480) {
		cost = 11.75;
	}
	else if (minutes > 480 && days == 0 ) {
		cost=	13.0;
	}
	else {
		cost = (days * 13.0) + calculateCost(minutesLeft);
	}
	return cost;
	}
		
	}
	
	

