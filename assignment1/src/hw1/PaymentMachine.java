package hw1;

public class PaymentMachine
{	
	
	private Ticket tick = new Ticket(0); // constructs new ticket
	private SimpleClock c = new SimpleClock();// constructs new clock
	private  double totalPayment; // total amount PAID
	private double amountDue;  // total amount DUE
	private boolean progress = false; // If a transaction is in progress

	/** Constructs a new payment machine with a specific given clock
	 * starts with total payment of 0
	 * starts with a total payment due of 0
	 * @param givenClock uses the internal clock
	 */
	public PaymentMachine(SimpleClock givenClock) {
		c = givenClock;
		totalPayment = 0.0;
		this.amountDue = 0.0;
	}
	
	/**simulates inserting the ticket into the payment machine
	 * changes the progress variables if the machine was empty
	 * @param t the ticket is being inserted
	 */
	public void insertTicket(Ticket t) {
	 	if (progress == true) {
	 	}
	 	else { 
	 	tick = t;
	 	progress = true;
	 	}
	}
	
	/** simulates returning a ticket from the payment machine if there was one inside
	 * does nothing if no ticket was inside
	 * 
	 * @return ticket if progress is true
	 */
	public Ticket getCurrentTicket() {
		if (progress == true) {
			return tick;
		} 
		else {
			return null;
		}
	}
	
	/** shows the current state of the machine if it was being used or not
	 * 
	 * @return the current state of the machine
	 */
	public boolean inProgress() {
	
	return progress;
	}
	
	/**Returns the payment due for the ticket currently in the machine.
	 *  If no transaction is in progress,
	 *  returns 0.0.
	 * 
	 * @return the amount due for the ticket
	 */
	public double getPaymentDue() {
		if (inProgress() && tick.getPaymentTime() == 0) {
		amountDue = ParkingRateUtil.calculateCost(c.getTime() - tick.getStartTime());
		return amountDue; // the case where the ticket has payment time of 0 (simple case)
		}
		else if (inProgress() && tick.getPaymentTime() !=0){
		
		amountDue = ParkingRateUtil.calculateCost(c.getTime()-tick.getStartTime()) - ParkingRateUtil.calculateCost(tick.getPaymentTime()-tick.getStartTime()) ;
		return amountDue;// more complicated case
		}
		else {
		return 0.0; // default
		}
	}
	
	/** simulates making a payment for the ticket
	 * sets the payment time for the ticket 
	 */
	public void makePayment() {
		this.totalPayment += this.getPaymentDue();
		tick.setPaymentTime(c.getTime());// setting payment time
	}
	
	/** simulating ejecting the ticket from the payment machine
	 *  changing the progress variable accordingly
	 */
	public void ejectTicket() {
		if (progress == true){ 
			progress = false; // updates the progress variable
		}
	}
	
	/** Returns the total payments made for this machine
	 * 
	 * @return the total payments made
	 */
	public double getTotalPayments() {
		return this.totalPayment; 
	}
	
	
}
  
	

