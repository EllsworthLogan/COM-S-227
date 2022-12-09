package hw2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

import org.junit.*;

/**
 * A class HideableCharTest that is a JUnit test for the class HideableChar. 
 * 
 * @author logan
 */
public class HideableCharTest
{
	//isHidden() test cases
	
	@Test
	public void testIsHidden1() {
		HideableChar c = new HideableChar('a');
		String msg = "Checks whether the alphabetical char is initially hidden. Expected <True> but was <False> ";
		assertTrue(msg, c.isHidden());
	}

	@Test
	public void testIsHidden2() {
		HideableChar c = new HideableChar('P');
		String msg = "Checks whether the alphabetical char is initially hidden. Expected <True> but was <False> ";
		assertTrue(msg, c.isHidden());
	}
	
	@Test
	public void testIsHidden3() {
		HideableChar c = new HideableChar(' ');
		String msg = "Checks whether the non-alphabetical char is initially hidden. Expected <False> but was <True> ";
		assertFalse(msg, c.isHidden());
	}
	
	@Test
	public void testIsHidden4() {
		HideableChar c = new HideableChar('^');
		String msg = "Checks whether the non-alphabetical char is initially hidden. Expected <False> but was <True> ";
		assertFalse(msg, c.isHidden());
	}
	
	//hide() test cases.
	 
	 private HideableChar c1;
	 private HideableChar c2;
	 private HideableChar c3;

	 @Before
	 public void setup() {
	  c1 = new HideableChar('A');
	  c2 = new HideableChar('%');
	  c3 = new HideableChar(' ');
	 }
	 
	@Test
	public void testHide1() {
		String msg = "Checks whether the non-alphabetical char is initially hidden. Error - initial state should be not hidden. ";
		assertFalse(msg, c2.isHidden());

		c2.hide();
		assertTrue(c2.isHidden());
	}

	@Test
	public void testHide2() {
		String msg = "Checks whether the non-alphabetical char is displayed. Error - initial value should be \"%\". ";
		assertEquals(msg, "%", c2.getDisplayedChar());

		c2.hide();
		assertEquals(null, c2.getDisplayedChar());
	}
	
	@Test
	public void testHide3() {
		String msg = "Checks whether the non-alphabetical char is initially hidden. Error - initial state should be not hidden. ";
		assertFalse(msg, c3.isHidden());

		c3.hide();
		assertTrue(c3.isHidden());
	}

	@Test
	public void testHide4() {
		String msg = "Checks whether the non-alphabetical char is displayed. Error - initial value should be \" \". ";
		assertEquals(msg, " ", c3.getDisplayedChar());

		c3.hide();
		assertEquals(null, c3.getDisplayedChar());
	}
	
	
	//unHide() test cases
	
	@Test
	public void testunHide1() {
		String msg = "Checks whether the alphabetical char is hidden. Error - initial state should be hidden. ";
		assertTrue(msg, c1.isHidden());

		c1.unHide();
		assertFalse(c1.isHidden());
	}

	@Test
	public void testunHide2() {
		String msg = "Checks whether the non-alphabetical char is  equal to its String value. Error - initial value should be \"%\". ";
		assertEquals(msg, "%", c2.getDisplayedChar());

		c2.unHide();
		assertEquals("%", c2.getDisplayedChar());
	}
	
	@Test
	public void testunHide3() {
		String msg = "Checks whether the non-alphabetical char is displayed. Error - initial state should be not hidden. ";
		assertFalse(msg, c3.isHidden());

		c3.unHide();
		assertFalse(c3.isHidden());
	}

	@Test
	public void testunHide4() {
		String msg = "Checks whether the non-alphabetical char is equal to its String value. Error - initial value should be \" \". ";
		assertEquals(msg, " ", c3.getDisplayedChar());

		c3.unHide();
		assertEquals(" ", c3.getDisplayedChar());
	}
	
	
	//matches() test cases.

	@Test
	public void testMatches1() {
		String msg = "Checks whether the alphabetical char matches its String value. Expected <True> but was <False> ";
		assertTrue(msg, c1.matches('A'));
	}

	@Test
	public void testMatches2() {
		String msg = "Checks whether the non-alphabetical char matches its String value. Expected <True> but was <False> ";
		assertTrue(msg, c2.matches('%'));
	}
		 
	@Test
	public void testMatches3() {
		String msg = "Checks whether the non-alphabetical char matches its String value. Expected <True> but was <False> ";
		assertTrue(msg, c3.matches(' '));
	}

	@Test
	public void testMatches4() {
		String msg = "Checks whether the alphabetical char matches its String value. Expected <False> but was <True> ";
		assertFalse(msg, c1.matches('B'));
	}

	@Test
	public void testMatches5() {
		String msg = "Checks whether the non-alphabetical char matches its String value. Expected <False> but was <True> ";
		assertFalse(msg, c2.matches('$'));
	}

	@Test
	public void testMatches6() {
		String msg = "Checks whether the alphabetical char matches its String value. Expected <False> but was <True> ";
		assertFalse(msg, c1.matches('a'));
	}
		 
	@Test
	public void testMatches7() {
		String msg = "Checks whether the non-alphabetical char matches its String value. Expected <False> but was <True> ";
		assertFalse(msg, c3.matches('.'));
	}
	
	
	//getDisplayedChar() test cases
	
	@Test
	public void testgetDisplayedChar1(){
		HideableChar c = new HideableChar('a');
		String msg = "A char consisting of an alphabetical character should return null because it is hidden. ";
		assertEquals(msg, null, c.getDisplayedChar());
	}
	
	@Test
	public void testgetDisplayedChar2(){
		HideableChar c = new HideableChar('Z');
		String msg = "A char consisting of an alphabetical character should return null because it is hidden. ";
		assertEquals(msg, null, c.getDisplayedChar());
	}
	
	@Test
	public void testgetDisplayedChar3(){
		HideableChar c = new HideableChar('+');
		String msg = "A char consisting of a non-alphabetical character should not return null because it is not hidden. ";
		assertNotEquals(msg, null, c.getDisplayedChar());
	}
	
	@Test
	public void testgetDisplayedChar4(){
		HideableChar c = new HideableChar(' ');
		String msg = "A char consisting of a non-alphabetical character should not return null because it is not hidden. ";
		assertNotEquals(msg, null, c.getDisplayedChar());
	}
	
	
	//getHiddenChar() test cases
	
	@Test
	public void testgetHiddenChar1(){
		HideableChar c = new HideableChar('a');
		String msg = "Should be not return null because the method returns the string whether hidden or not. ";
		assertNotEquals(msg, null, c.getHiddenChar());
	}
	
	@Test
	public void testgetHiddenChar2(){
		HideableChar c = new HideableChar(' ');
		String msg = "Should not return null because the method returns the string whether hidden or not. ";
		assertNotEquals(msg, null, c.getHiddenChar());
	}
	
	@Test
	public void testgetHiddenChar3(){
		HideableChar c = new HideableChar('a');
		String msg = "Should return the character as a String because the method returns the string whether hidden or not";
		assertEquals(msg, "a", c.getHiddenChar());
	}
	
	@Test
	public void testgetHiddenChar4(){
		HideableChar c = new HideableChar(' ');
		String msg = "Should return the character as a String because the method returns the string whether hidden or not";
		assertEquals(msg, " ", c.getHiddenChar());
	} 
	
}
