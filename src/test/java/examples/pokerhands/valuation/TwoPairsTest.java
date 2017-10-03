package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.HandUtil;

public class TwoPairsTest {
	
	HandRanking twoPairs = new TwoPairs();
	Hand hand = null;

	@Test
	public void testNoPair() {
		hand = HandUtil.createHand("D2", "D3", "D4", "D5", "D6");
		
		Valuation valuation = twoPairs.evaluate(hand);
		
		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testSimple2Pairs() {
		hand = HandUtil.createHand("D2", "C2", "D4", "C6", "D6");
		
		Valuation valuation = twoPairs.evaluate(hand);
		
		assertEquals(Rank.TWO_PAIRS, valuation.getRank());
	}

	@Test
	public void testHigherFirstPair() {
		hand = HandUtil.createHand("D3", "C3", "D4", "C6", "D6");
		Hand hand2 = HandUtil.createHand("H2", "S2", "S4", "H7", "S7");
		
		Valuation v1 = twoPairs.evaluate(hand);
		Valuation v2 = twoPairs.evaluate(hand2);
		
		assertTrue(v1.compareTo(v2) < 0);
	}

	@Test
	public void testHigherSecondPair() {
		hand = HandUtil.createHand("D3", "C3", "D4", "C6", "D6");
		Hand hand2 = HandUtil.createHand("H2", "S2", "S4", "H6", "S6");
		
		Valuation v1 = twoPairs.evaluate(hand);
		Valuation v2 = twoPairs.evaluate(hand2);
		
		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testHigherRemainingCard() {
		hand = HandUtil.createHand("D3", "C3", "D4", "C6", "D6");
		Hand hand2 = HandUtil.createHand("H3", "S3", "S5", "H6", "S6");
		
		Valuation v1 = twoPairs.evaluate(hand);
		Valuation v2 = twoPairs.evaluate(hand2);
		
		assertTrue(v1.compareTo(v2) < 0);
	}

	@Test
	public void testEqualsTwoPairs() {
		hand = HandUtil.createHand("D3", "C3", "D4", "C6", "D6");
		Hand hand2 = HandUtil.createHand("H3", "S3", "S4", "H6", "S6");
		
		Valuation v1 = twoPairs.evaluate(hand);
		Valuation v2 = twoPairs.evaluate(hand2);
		
		assertEquals(0, v1.compareTo(v2));
	}

}
