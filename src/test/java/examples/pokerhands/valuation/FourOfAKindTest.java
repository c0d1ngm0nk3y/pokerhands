package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.HandUtil;

public class FourOfAKindTest {

	HandRanking four = new FourOfAKind();
	Hand hand = null;

	@Test
	public void testNoMatch() {
		hand = HandUtil.createHand("D2", "D3", "D4", "D5", "D6");

		Valuation valuation = four.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testFourKings() {
		hand = HandUtil.createHand("D2", "SK", "DK", "CK", "HK");

		Valuation valuation = four.evaluate(hand);

		assertEquals(Rank.FOUR_KIND, valuation.getRank());
	}

	@Test
	public void testThreeKings() {
		hand = HandUtil.createHand("D2", "D3", "DK", "CK", "HK");

		Valuation valuation = four.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testFourJacks() {
		hand = HandUtil.createHand("DA", "DJ", "DJ", "CJ", "HJ");

		Valuation valuation = four.evaluate(hand);

		assertEquals(Rank.FOUR_KIND, valuation.getRank());
	}

	@Test
	public void testFourQueensBeatFourTens() {
		hand = HandUtil.createHand("DA", "SQ", "DQ", "CQ", "HQ");
		Hand hand2 = HandUtil.createHand("SA", "ST", "DT", "CT", "HT");

		Valuation v1 = four.evaluate(hand);
		Valuation v2 = four.evaluate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

}
