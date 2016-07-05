package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.TestUtils;

public class FourOfAKindTest {

	HandRanking four = new FourOfAKind();
	Hand hand = null;

	@Test
	public void testNoMatch() {
		hand = TestUtils.createHand("D2", "D3", "D4", "D5", "D6");

		Valuation valuation = four.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testFourKings() {
		hand = TestUtils.createHand("D2", "SK", "DK", "CK", "HK");

		Valuation valuation = four.evaluate(hand);

		assertEquals(Rank.FOUR_KIND, valuation.getRank());
	}

	@Test
	public void testThreeKings() {
		hand = TestUtils.createHand("D2", "D3", "DK", "CK", "HK");

		Valuation valuation = four.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testFourJacks() {
		hand = TestUtils.createHand("DA", "DJ", "DJ", "CJ", "HJ");

		Valuation valuation = four.evaluate(hand);

		assertEquals(Rank.FOUR_KIND, valuation.getRank());
	}

	@Test
	public void testFourQueensBeatFourTens() {
		hand = TestUtils.createHand("DA", "SQ", "DQ", "CQ", "HQ");
		Hand hand2 = TestUtils.createHand("SA", "ST", "DT", "CT", "HT");

		Valuation v1 = four.evaluate(hand);
		Valuation v2 = four.evaluate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

}
