package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.TestUtils;

public class RaterTest {
	
	private Rater rater = new Rater();

	@Test
	public void testNoRankings() {
		Hand hand = TestUtils.createHand("H2", "H3", "H4", "H5", "H6");
		
		Valuation valuation = rater.rate(hand);
		
		assertEquals(Rank.NONE, valuation.getRank());
	}

	@Test
	public void testOnlyHighCardAvailable() {
		Hand hand = TestUtils.createHand("H2", "H3", "H4", "H5", "H6");
		rater.register(new HighCard());
		
		Valuation valuation = rater.rate(hand);
		
		assertEquals(Rank.HIGH_CARD, valuation.getRank());
	}

	@Test
	public void testFlush() {
		Hand hand = TestUtils.createHand("H2", "H3", "H4", "H5", "H6");
		rater.register(new Flush());
		rater.register(new HighCard());
		
		Valuation valuation = rater.rate(hand);
		
		assertEquals(Rank.FLUSH, valuation.getRank());
	}

	@Test
	public void testNoFlush() {
		Hand hand = TestUtils.createHand("H2", "H3", "H4", "H5", "C6");
		rater.register(new Flush());
		rater.register(new HighCard());
		
		Valuation valuation = rater.rate(hand);
		
		assertEquals(Rank.HIGH_CARD, valuation.getRank());
	}

}
