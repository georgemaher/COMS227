package hw1;

public class TicketDispensertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleClock c = new SimpleClock();
		TicketDispenser td = new TicketDispenser(c);
		c.timePasses(10);
		Ticket t = td.takeTicket();
		System.out.println(t.getStartTime()); // Expected 10
		System.out.println(t.getPaymentTime());
	}

}
