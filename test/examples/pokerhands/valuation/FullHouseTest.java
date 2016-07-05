package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.TestUtils;

public class FullHouseTest {
	
	HandRanking fullHouse = new FullHouse();
	Hand hand = null;

	@Test
	public void testNoFullHouse() {
		hand = TestUtils.createHand("D2", "C2", "DQ", "CK", "HK");

		Valuation valuation = fullHouse.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testFullHouseKings() {
		hand = TestUtils.createHand("D2", "C2", "DK", "CK", "HK");

		Valuation valuation = fullHouse.evaluate(hand);

		assertEquals(Rank.FULL_HOUSE, valuation.getRank());
	}

	@Test
	public void testJustThreeKings() {
		hand = TestUtils.createHand("D3", "C2", "DK", "CK", "HK");

		Valuation valuation = fullHouse.evaluate(hand);

		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testFullHouseKingsBeatsQueen() {
		hand = TestUtils.createHand("D2", "C2", "DK", "CK", "HK");
		Hand hand2 = TestUtils.createHand("DA", "CA", "DQ", "CQ", "HQ");

		Valuation v1 = fullHouse.evaluate(hand);
		Valuation v2 = fullHouse.evaluate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

}
