package examples.pokerhands.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {
	
	Hand hand = null;

	@Test
	public void testConstructor() {
		hand = createHand("C2", "D3", "H4", "S5", "C6");
	}

	@Test
	public void testHandHas5Cards() {
		hand = createHand("C2", "D3", "H4", "S5", "C6");
		
		Card[] cards = hand.getCards();
		assertEquals(5, cards.length);
	}

	@Test
	public void testHandIsSorted() {
		hand = createHand("CQ", "DK", "HA", "SJ", "HT");
		
		Card[] cards = hand.getCards();
		assertEquals(Value.TEN, cards[0].getValue());
		assertEquals(Value.ACE, cards[4].getValue());
	}

	private Hand createHand(String c1, String c2, String c3, String c4, String c5) {
		Hand hand = TestUtils.createHand(c1, c2, c3, c4, c5);
		return hand;
	}

}
