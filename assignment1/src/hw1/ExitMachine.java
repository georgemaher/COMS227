package hw1;

public class ExitMachine
{
	private SimpleClock  c = new SimpleClock(); // internal clock
	private int exitCount; // number of vehicles exited 
	private boolean state; // returns true or false
	
	/** Constructs the exit machine  
	 * starts with exit count of 0 
	 * @param givenClock uses the SimpleClock class 
	 */
 
	public ExitMachine(SimpleClock givenClock) {
	 exitCount = 0;
	 c = givenClock;
	}
	
	/** Checks the ticket payment time, if certain conditions are met, it returns true
	 * returns false otherwise
	 * doesn't modify the ticket
	 * @param t the ticket inserted into the machine
	 * @return returns the state variable
	 */
	public boolean insertTicket(Ticket t) {
	 state = false;
	 if ((c.getTime() - t.getPaymentTime() ) <= ParkingRateUtil.EXIT_TIME_LIMIT && t.getPaymentTime()!=0 ) {
		 state = true; // if the time is within the specified range, it returns true
	 }
	 if (state != false) {
		 exitCount += 1;
	 }
	 return state;
	}
 
	/** returns the value of successfully exited vehicles count 
	 * doesn't modify anything 
	 * @return number of exited vehicles
	 */
	public int getExitCount() {
	return exitCount;
	}

}
