package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.HandUtil;

public class PairTest {
	
	HandRanking pair = new Pair();
	Hand hand = null;

	@Test
	public void testNoPair() {
		hand = HandUtil.createHand("D2", "D3", "D4", "D5", "D6");
		
		Valuation valuation = pair.evaluate(hand);
		
		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testPairOfHighestCards() {
		hand = HandUtil.createHand("D2", "D3", "D4", "DA", "CA");
		
		Valuation valuation = pair.evaluate(hand);
		
		assertEquals(Rank.PAIR, valuation.getRank());
	}

	@Test
	public void testPairOfSecondHighestCards() {
		hand = HandUtil.createHand("D2", "D3", "DQ", "CQ", "CK");
		
		Valuation valuation = pair.evaluate(hand);
		
		assertEquals(Rank.PAIR, valuation.getRank());
	}

	@Test
	public void testPairOfLowestCards() {
		hand = HandUtil.createHand("D2", "C2", "DQ", "CA", "CK");
		
		Valuation valuation = pair.evaluate(hand);
		
		assertEquals(Rank.PAIR, valuation.getRank());
	}

	@Test
	public void testHigherPair() {
		hand = HandUtil.createHand("D2", "C2", "DQ", "CA", "CK");
		Hand hand2 = HandUtil.createHand("H4", "H6", "HQ", "HA", "SQ");
		
		Valuation v1 = pair.evaluate(hand);
		Valuation v2 = pair.evaluate(hand2);
		
		assertTrue(v1.compareTo(v2) < 0);
	}

	@Test
	public void testHigherPairWithTieBreaker() {
		hand = HandUtil.createHand("D4", "C4", "D2", "CA", "CK");
		Hand hand2 = HandUtil.createHand("H4", "S4", "H3", "HA", "SK");
		
		Valuation v1 = pair.evaluate(hand);
		Valuation v2 = pair.evaluate(hand2);
		
		assertTrue(v1.compareTo(v2) < 0);
	}

}
