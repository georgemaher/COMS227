package lab3;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import balloon.Balloon;

public class BalloonTest {
	
	private Balloon  b ; 
	
	@Before 
	public void setup() {
		b  = new Balloon (10);
		
	}
	

	@Test
	public void testBlowingPopped() {
	b.pop();
	b.blow(1);
	assertEquals(0, b.getRadius());
	}

	@Test
	public void doubleBlow() {
	b.blow(5);
	b.blow(5);
	assertEquals(10, b.getRadius());
	}

	@Test
	public void deflatePopped() {
	b.deflate();
	assertEquals(false, b.isPopped());
	}
}
