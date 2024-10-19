package hw1;

public class ExitMachineTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleClock c = new SimpleClock();
		ExitMachine em = new ExitMachine(c);
		Ticket t = new Ticket(c.getTime());
		t.setPaymentTime(10);
		c.timePasses(20);
		boolean canExit = em.insertTicket(t);
		System.out.println(canExit); // expected true
		Ticket t2 = new Ticket(0);
		t2.setPaymentTime(30);
		c.timePasses(60);
		canExit = em.insertTicket(t2);
		System.out.println(canExit); // expected false
		System.out.println(em.getExitCount()); // expected 1
	}

}
