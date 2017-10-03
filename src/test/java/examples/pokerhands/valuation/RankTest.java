package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankTest {

	@Test
	public void testContainsAllHandsAndNone() {
		assertEquals(9 + 1, Rank.values().length);
	}

	@Test
	public void testNoneIsLowest() {
		assertEquals(0, Rank.NONE.ordinal());
	}
	
	@Test
	public void testToString() {
		assertEquals("Flush", Rank.FLUSH.toString());
		assertEquals("Four of a kind", Rank.FOUR_KIND.toString());
		assertEquals("Full House", Rank.FULL_HOUSE.toString());
		assertEquals("No ranking", Rank.NONE.toString());
		assertEquals("Pair", Rank.PAIR.toString());
		assertEquals("Straight", Rank.STRAIGHT.toString());
		assertEquals("Straight Flush", Rank.STRAIGHT_FLUSH.toString());
		assertEquals("Three of a kind", Rank.THREE_KIND.toString());
		assertEquals("Two Pairs", Rank.TWO_PAIRS.toString());
	}
	

}
