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

	@Test
	public void testToString() {
		card = new Card("D3");
		
		assertEquals("D3", card.toString());
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
    
    @Test
	public void testComparableLower() throws Exception {
		Card card1 = new Card("C3");
		Card card2 = new Card("H4");
		
		assertTrue(card1.compareTo(card2) < 0);
	}

    @Test
	public void testComparableHigher() throws Exception {
		Card card1 = new Card("SA");
		Card card2 = new Card("CQ");
		
		assertTrue(card1.compareTo(card2) > 0);
	}

    @Test
	public void testComparableEquals() throws Exception {
		Card card1 = new Card("SK");
		Card card2 = new Card("HK");
		
		assertEquals(0, card1.compareTo(card2));
	}

    @Test
	public void testEquals() throws Exception {
		Card card1 = new Card("S3");
		Card card2 = new Card("S3");
		
		assertEquals(card1, card2);
		assertEquals(card1.hashCode(), card2.hashCode());
	}

    @Test
	public void testEqualsIdentity() throws Exception {
		Card card1 = new Card("S3");
		
		assertEquals(card1, card1);
		assertEquals(card1.hashCode(), card1.hashCode());
	}
    
    @Test
	public void testNotEqualsValue() throws Exception {
		Card card1 = new Card("S3");
		Card card2 = new Card("S4");
		
		assertNotEquals(card1, card2);
		assertNotEquals(card1.hashCode(), card2.hashCode());
	}

    @Test
	public void testNotEqualsSuit() throws Exception {
		Card card1 = new Card("S3");
		Card card2 = new Card("H3");
		
		assertNotEquals(card1, card2);
		assertNotEquals(card1.hashCode(), card2.hashCode());
    }
	
    @Test
   	public void testNotEquals2Kings() throws Exception {
   		Card card1 = new Card("SK");
   		Card card2 = new Card("DK");
   		
   		assertNotEquals(card1, card2);
   		assertNotEquals(card1.hashCode(), card2.hashCode());
       }
}
