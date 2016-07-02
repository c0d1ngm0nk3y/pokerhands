package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Value;

public class ValuationTest {

	Valuation valuation = null;
	
	@Test
	public void testConstructor() {
		valuation = new Valuation(Rank.FLUSH, Value.TWO);
		
		assertEquals(Rank.FLUSH, valuation.getRank());
	}
	
	@Test
	public void testSoringHigherRank() throws Exception {
		Valuation v1 = new Valuation(Rank.FOUR_KIND, Value.TWO);
		Valuation v2 = new Valuation(Rank.HIGH_CARD, Value.THREE);
		
		assertTrue(v1.compareTo(v2) > 0);
	}
	
	@Test
	public void testSoringLowerRank() throws Exception {
		Valuation v1 = new Valuation(Rank.HIGH_CARD, Value.ACE);
		Valuation v2 = new Valuation(Rank.FOUR_KIND, Value.TWO);
		
		assertTrue(v1.compareTo(v2) < 0);
	}

	@Test
	public void testSoringEqualRank() throws Exception {
		Valuation v1 = new Valuation(Rank.FOUR_KIND, Value.TWO);
		Valuation v2 = new Valuation(Rank.FOUR_KIND, Value.TWO);
		
		assertEquals(0, v1.compareTo(v2));
	}
	
	@Test
	public void testSoringHigherTieBreaker() throws Exception {
		Valuation v1 = new Valuation(Rank.FOUR_KIND, Value.FOUR);
		Valuation v2 = new Valuation(Rank.FOUR_KIND, Value.THREE);
		
		assertTrue(v1.compareTo(v2) > 0);
	}
	
	@Test
	public void testSoringLowerTieBreaker() throws Exception {
		Valuation v1 = new Valuation(Rank.HIGH_CARD, Value.TWO);
		Valuation v2 = new Valuation(Rank.HIGH_CARD, Value.THREE);
		
		assertTrue(v1.compareTo(v2) < 0);
	}

}
