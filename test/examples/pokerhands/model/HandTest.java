package examples.pokerhands.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {
	
	Hand hand = null;

	@Test
	public void testConstructor() {
		hand = TestUtils.createHand("C2", "D3", "H4", "S5", "C6");
	}

	@Test
	public void testHandHas5Cards() {
		hand = TestUtils.createHand("C2", "D3", "H4", "S5", "C6");
		
		Card[] cards = hand.getCards();
		assertEquals(5, cards.length);
	}

	@Test
	public void testHandHas5Cards2Kings() {
		hand = TestUtils.createHand("D2", "D5", "H3", "SK", "DK");
		
		Card[] cards = hand.getCards();
		assertEquals(5, cards.length);
	}

	@Test
	public void testHandIsSorted() {
		hand = TestUtils.createHand("CQ", "DK", "HA", "SJ", "HT");
		
		Card[] cards = hand.getCards();
		assertEquals(Value.TEN, cards[0].getValue());
		assertEquals(Value.ACE, cards[4].getValue());
	}

}
