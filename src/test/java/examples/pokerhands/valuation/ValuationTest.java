package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Value;

public class ValuationTest {

	Valuation valuation = null;
	
	@Test
	public void testConstructor() {
		valuation = new Valuation(Rank.FLUSH);
		
		assertEquals(Rank.FLUSH, valuation.getRank());
	}
	
	@Test
	public void testSoringHigherRank() throws Exception {
		Valuation v1 = new Valuation(Rank.FOUR_KIND);
		Valuation v2 = new Valuation(Rank.HIGH_CARD);
		
		assertTrue(v1.compareTo(v2) > 0);
	}
	
	@Test
	public void testSoringLowerRank() throws Exception {
		Valuation v1 = new Valuation(Rank.HIGH_CARD);
		Valuation v2 = new Valuation(Rank.FOUR_KIND);
		
		assertTrue(v1.compareTo(v2) < 0);
	}

	@Test
	public void testSoringEqualRank() throws Exception {
		Valuation v1 = new Valuation(Rank.FOUR_KIND);
		Valuation v2 = new Valuation(Rank.FOUR_KIND);
		
		assertEquals(0, v1.compareTo(v2));
	}
	
	@Test
	public void testSoringEqualWithTieBreaker() throws Exception {
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

	@Test
	public void testSoringLower3rdTieBreaker() throws Exception {
		Valuation v1 = new Valuation(Rank.HIGH_CARD, Value.KING, Value.QUEEN, Value.TWO);
		Valuation v2 = new Valuation(Rank.HIGH_CARD, Value.KING, Value.QUEEN, Value.THREE);
		
		assertTrue(v1.compareTo(v2) < 0);
	}

	@Test
	public void testSoringEqualDifferentNumberTieBreaker() throws Exception {
		Valuation v1 = new Valuation(Rank.HIGH_CARD, Value.KING, Value.QUEEN, Value.TWO);
		Valuation v2 = new Valuation(Rank.HIGH_CARD, Value.KING, Value.QUEEN);
		
		assertEquals(0, v1.compareTo(v2));
	}

}
