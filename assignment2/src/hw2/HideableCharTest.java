package hw2;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class HideableCharTest
{
	@Test
	public void testIsHidden()
	{
		HideableChar c = new HideableChar('a');
		assertTrue(c.isHidden());
	}
	
	@Test
	public void testIsHidden2()
	{
		HideableChar c = new HideableChar('a');
		c.unHide();
		assertTrue(!c.isHidden());
	}
	
	@Test
	public void testIsHidden3()
	{
		HideableChar c = new HideableChar('a');
		c.unHide();
		c.hide();
		assertTrue(c.isHidden());
	}
	
	@Test
	public void testIsHidden4()
	{
		HideableChar c = new HideableChar('a');
		c.unHide();
		c.hide();
		assertTrue(c.matches('a'));
	}
	
	@Test
	public void testIsHidden5()
	{
		HideableChar c = new HideableChar('a');
		c.unHide();
		c.hide();
		assertTrue(!c.matches('c'));
	}
	
}
