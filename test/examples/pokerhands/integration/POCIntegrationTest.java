package examples.pokerhands.integration;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.TestUtils;
import examples.pokerhands.valuation.Flush;
import examples.pokerhands.valuation.HighCard;
import examples.pokerhands.valuation.Rater;
import examples.pokerhands.valuation.Valuation;

public class POCIntegrationTest {
	
	Rater rater = new Rater();
	Hand hand1 = null;
	Hand hand2 = null;
	
	@Before
	public void setup() {
		rater.register(new HighCard());
		rater.register(new Flush());
	}

	@Test
	public void testFlushBeatsHighCard() {
		hand1 = TestUtils.createHand("D2", "D3", "D4", "D5", "D6");
		hand2 = TestUtils.createHand("C5", "DT", "HK", "CA", "S3");
		
		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);
		
		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testHighCardAceBeatsHighCardQueen() {
		hand1 = TestUtils.createHand("C5", "DT", "HK", "CA", "S3");
		hand2 = TestUtils.createHand("D5", "ST", "DQ", "H2", "C6");
		
		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);
		
		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testFlushBeatsFlushByOne() {
		hand1 = TestUtils.createHand("DK", "D3", "D4", "D5", "D6");
		hand2 = TestUtils.createHand("HK", "H2", "H4", "H5", "H6");
		
		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);
		
		assertTrue(v1.compareTo(v2) > 0);
	}
	
}
