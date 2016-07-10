package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.HandUtil;

public class ThreeOfAKindTest {

	HandRanking three = new ThreeOfAKind();
	Hand hand = null;

	@Test
	public void testNoMatch() {
		hand = HandUtil.createHand("D2", "D3", "D4", "D5", "D6");

		Valuation valuation = three.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testThreeKings() {
		hand = HandUtil.createHand("D2", "D3", "DK", "CK", "HK");

		Valuation valuation = three.evaluate(hand);

		assertEquals(Rank.THREE_KIND, valuation.getRank());
	}

	@Test
	public void testTwoKings() {
		hand = HandUtil.createHand("D2", "D3", "DQ", "CK", "HK");

		Valuation valuation = three.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testThreeJacks() {
		hand = HandUtil.createHand("DA", "DQ", "DJ", "CJ", "HJ");

		Valuation valuation = three.evaluate(hand);

		assertEquals(Rank.THREE_KIND, valuation.getRank());
	}

	@Test
	public void testThreeJacksBeatThreeTens() {
		hand = HandUtil.createHand("DA", "DQ", "DJ", "CJ", "HJ");
		Hand hand2 = HandUtil.createHand("SA", "SQ", "DT", "CT", "HT");

		Valuation v1 = three.evaluate(hand);
		Valuation v2 = three.evaluate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

}
