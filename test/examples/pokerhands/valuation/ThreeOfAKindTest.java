package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.TestUtils;

public class ThreeOfAKindTest {

	HandRanking three = new ThreeOfAKind();
	Hand hand = null;

	@Test
	public void testNoMatch() {
		hand = TestUtils.createHand("D2", "D3", "D4", "D5", "D6");

		Valuation valuation = three.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testThreeKings() {
		hand = TestUtils.createHand("D2", "D3", "DK", "CK", "HK");

		Valuation valuation = three.evaluate(hand);

		assertEquals(Rank.THREE_KIND, valuation.getRank());
	}

	@Test
	public void testTwoKings() {
		hand = TestUtils.createHand("D2", "D3", "DQ", "CK", "HK");

		Valuation valuation = three.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testThreeJacks() {
		hand = TestUtils.createHand("DA", "DQ", "DJ", "CJ", "HJ");

		Valuation valuation = three.evaluate(hand);

		assertEquals(Rank.THREE_KIND, valuation.getRank());
	}

	@Test
	public void testThreeJacksBeatThreeTens() {
		hand = TestUtils.createHand("DA", "DQ", "DJ", "CJ", "HJ");
		Hand hand2 = TestUtils.createHand("SA", "SQ", "DT", "CT", "HT");

		Valuation v1 = three.evaluate(hand);
		Valuation v2 = three.evaluate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

}
