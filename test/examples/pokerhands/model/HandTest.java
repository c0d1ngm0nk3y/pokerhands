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

	private Hand createHand(String v1, String v2, String v3, String v4, String v5) {
		return new Hand(new Card(v1), new Card(v2), new Card(v3), new Card(v4), new Card(v5));
	}

}
