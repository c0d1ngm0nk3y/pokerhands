package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.TestUtils;

public class StraightTest {

	HandRanking straight = new Straight();
	Hand hand = null;

	@Test
	public void testNoStraight() {
		hand = TestUtils.createHand("D3", "HJ", "D4", "D5", "CA");

		Valuation valuation = straight.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testStraightTwoUp() {
		hand = TestUtils.createHand("D2", "C3", "D4", "D5", "C6");

		Valuation valuation = straight.evaluate(hand);

		assertEquals(Rank.STRAIGHT, valuation.getRank());
	}

	@Test
	public void testStraightAceDown() {
		hand = TestUtils.createHand("DT", "CJ", "HA", "DK", "CQ");

		Valuation valuation = straight.evaluate(hand);

		assertEquals(Rank.STRAIGHT, valuation.getRank());
	}

	@Test
	public void testStraightAceDownIncomplete() {
		hand = TestUtils.createHand("D9", "CJ", "HA", "DK", "CQ");

		Valuation valuation = straight.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testStraightHighCard() {
		hand = TestUtils.createHand("DT", "CJ", "HA", "DK", "CQ");
		Hand hand2 = TestUtils.createHand("C9", "HT", "SJ", "SQ", "HK");

		Valuation v1 = straight.evaluate(hand);
		Valuation v2 = straight.evaluate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

}
