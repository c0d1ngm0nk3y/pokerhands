package examples.pokerhands.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {
	
	public Card card = null;

	@Test
	public void testConstructorC2() {
		card = new Card("C2");
		
		assertEquals(Suit.CLUBS, card.getSuit());
		assertEquals(Value.TWO, card.getValue());
	}

	@Test
	public void testConstructorD3() {
		card = new Card("D3");
		
		assertEquals(Suit.DIAMONDS, card.getSuit());
		assertEquals(Value.THREE, card.getValue());
	}
	
    @Test(expected=IllegalArgumentException.class)
	public void testConstructorArgTooShort() throws Exception {
		card = new Card("D");	
	}

    @Test(expected=IllegalArgumentException.class)
	public void testConstructorArgTooLong() throws Exception {
		card = new Card("D33");		
	}

    @Test(expected=IllegalArgumentException.class)
	public void testConstructorWrongSuit() throws Exception {
		card = new Card("X3");		
	}

    @Test(expected=IllegalArgumentException.class)
	public void testConstructorWrongValue() throws Exception {
		card = new Card("SX");		
	}

}
