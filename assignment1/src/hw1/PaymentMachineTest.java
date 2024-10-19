package hw1;

public class PaymentMachineTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleClock c = new SimpleClock();
		c.timePasses(10);
		PaymentMachine pm = new PaymentMachine(c);
		Ticket t = new Ticket(c.getTime());
		c.timePasses(60);
		pm.insertTicket(t);
		System.out.println(pm.getPaymentDue()); // expected 2.00
		pm.ejectTicket(); // eject without paying
		c.timePasses(75);
		pm.insertTicket(t);
		System.out.println(pm.getPaymentDue()); // expected 5.00

	}

}
