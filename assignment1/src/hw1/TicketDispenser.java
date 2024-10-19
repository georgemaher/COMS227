package hw1;

public class TicketDispenser
{
	private static SimpleClock c = new SimpleClock(); // instance variable to store the given clock
 
	/** Constructs a ticket dispensing machine that uses a given clock
	 * 
	 * @param givenClk is the parameter will be used to determine the time 
	 * of dispensed ticket
	 */
	public  TicketDispenser(SimpleClock givenClk) {
 	 	 c = givenClk;
 	}
 
	/** Creating and returning a new ticket which will have a start time equal to 
	 * the internal clock value and a payment time of 0
	 * 
	 * @return the new ticket
	 */
	public Ticket takeTicket() {
	 Ticket tckt = new Ticket(c.getTime());// creating a new ticket for the user
	 return tckt;
 }
 
 }
	

