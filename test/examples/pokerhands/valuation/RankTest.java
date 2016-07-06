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

}
