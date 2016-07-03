package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.TestUtils;

public class FlushTest {
	
	private HandRanking flush = new Flush();

	@Test
	public void testNoFlush() {
		Hand hand = TestUtils.createHand("D3", "H2", "SK", "CT", "DA");

		Valuation valuation = flush.evaluate(hand);
		
		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testClubFlush() {
		Hand hand = TestUtils.createHand("C3", "C2", "CK", "CT", "CA");

		Valuation valuation = flush.evaluate(hand);
		
		assertEquals(Rank.FLUSH, valuation.getRank());
	}

	@Test
	public void testHeartsFlush() {
		Hand hand = TestUtils.createHand("H4", "H2", "HQ", "HT", "HJ");

		Valuation valuation = flush.evaluate(hand);
		
		assertEquals(Rank.FLUSH, valuation.getRank());
	}
	
	@Test
	public void testHeartsFlushDraw() {
		Hand hand = TestUtils.createHand("H4", "H2", "HQ", "HT", "CJ");

		Valuation valuation = flush.evaluate(hand);
		
		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testFlushTieBreakers() {
		Hand hand1 = TestUtils.createHand("C3", "C2", "CK", "CT", "CA");
		Hand hand2 = TestUtils.createHand("D3", "D4", "DK", "DT", "DA");

		Valuation v1 = flush.evaluate(hand1);
		Valuation v2 = flush.evaluate(hand2);
		
		assertTrue(v1.compareTo(v2) < 0);
	}

}
