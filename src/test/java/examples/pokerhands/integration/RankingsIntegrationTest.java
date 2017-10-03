package examples.pokerhands.integration;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.HandUtil;
import examples.pokerhands.valuation.Rater;
import examples.pokerhands.valuation.Valuation;

public class RankingsIntegrationTest {

	Rater rater = new Rater();
	Hand hand1 = null;
	Hand hand2 = null;

	@Before
	public void setup() {
		rater.registerAll();
	}

	@Test
	public void testFlushBeatsHighCard() {
		hand1 = HandUtil.createHand("D2", "D3", "D4", "D5", "D6");
		hand2 = HandUtil.createHand("C5", "DT", "HK", "CA", "S3");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testHighCardAceBeatsHighCardQueen() {
		hand1 = HandUtil.createHand("C5", "DT", "HK", "CA", "S3");
		hand2 = HandUtil.createHand("D5", "ST", "DQ", "H2", "C6");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testFlushBeatsFlushByOne() {
		hand1 = HandUtil.createHand("DK", "D3", "D4", "D5", "D6");
		hand2 = HandUtil.createHand("HK", "H2", "H4", "H5", "H6");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testPairBeatsHighCard() {
		hand1 = HandUtil.createHand("D2", "D3", "D4", "D5", "H2");
		hand2 = HandUtil.createHand("C5", "DT", "HK", "CA", "S3");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testFlushBeatsPair() {
		hand1 = HandUtil.createHand("D2", "D3", "D4", "D5", "D6");
		hand2 = HandUtil.createHand("C5", "DT", "HK", "CA", "SA");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testTwoPairsBeatsPair() {
		hand1 = HandUtil.createHand("D2", "C2", "D4", "C4", "D6");
		hand2 = HandUtil.createHand("C5", "DT", "HK", "CA", "SA");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testThreeOfAKindBeatsTwoPairs() {
		hand1 = HandUtil.createHand("D2", "C2", "D4", "C4", "D6");
		hand2 = HandUtil.createHand("C5", "S5", "H5", "CA", "SQ");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) < 0);
	}

	@Test
	public void testFourOfAKindBeatsFlush() {
		hand1 = HandUtil.createHand("C2", "D3", "S4", "D5", "D6");
		hand2 = HandUtil.createHand("C5", "DA", "HA", "CA", "SA");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) < 0);
	}

	@Test
	public void testFullHouseBeatsFlush() {
		hand1 = HandUtil.createHand("D2", "D3", "D4", "D5", "DT");
		hand2 = HandUtil.createHand("C5", "H5", "HA", "CA", "SA");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) < 0);
	}

	@Test
	public void testStraightBeatsThreeOfAKind() {
		hand1 = HandUtil.createHand("H2", "D3", "D4", "S5", "D6");
		hand2 = HandUtil.createHand("C5", "H6", "HA", "CA", "SA");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testStraightFlushBeatsFourOfAKind() {
		hand1 = HandUtil.createHand("H2", "H3", "H4", "H5", "H6");
		hand2 = HandUtil.createHand("C5", "SA", "HA", "CA", "SA");

		Valuation v1 = rater.rate(hand1);
		Valuation v2 = rater.rate(hand2);

		assertTrue(v1.compareTo(v2) > 0);
	}

}
