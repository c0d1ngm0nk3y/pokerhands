package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.TestUtils;

public class StraightFlushTest {

	HandRanking straightFlush = new StraightFlush();
	Hand hand = null;

	@Test
	public void testNoStraightFlush() {
		hand = TestUtils.createHand("D3", "HJ", "D4", "D5", "CA");

		Valuation valuation = straightFlush.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testStraightButNoFlush() {
		hand = TestUtils.createHand("D2", "C3", "D4", "D5", "C6");

		Valuation valuation = straightFlush.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testFlushButNoStraigh() {
		hand = TestUtils.createHand("D2", "D3", "D4", "D5", "DQ");

		Valuation valuation = straightFlush.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testStraightFlushTwoUp() {
		hand = TestUtils.createHand("C2", "C3", "C4", "C5", "C6");

		Valuation valuation = straightFlush.evaluate(hand);

		assertEquals(Rank.STRAIGHT_FLUSH, valuation.getRank());
	}

	@Test
	public void testStraightFlushAceDown() {
		hand = TestUtils.createHand("DT", "DJ", "DA", "DK", "DQ");

		Valuation valuation = straightFlush.evaluate(hand);

		assertEquals(Rank.STRAIGHT_FLUSH, valuation.getRank());
	}

	@Test
	public void testStraightFlushAceDownIncomplete() {
		hand = TestUtils.createHand("D9", "DJ", "DA", "DK", "DQ");

		Valuation valuation = straightFlush.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testStraightFlushHighCard() {
		hand = TestUtils.createHand("DT", "DJ", "DA", "DK", "DQ");
		Hand hand2 = TestUtils.createHand("C9", "CT", "CJ", "CQ", "CK");

		Valuation v1 = straightFlush.evaluate(hand);
		Valuation v2 = straightFlush.evaluate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

}
