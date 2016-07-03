package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;
import examples.pokerhands.model.TestUtils;

public class HighCardTest {
	
	private HandRanking highCard = new HighCard();

	@Test
	public void testEvaluateHighCard() {
		Hand hand = TestUtils.createHand("D2", "D5", "H3", "SK", "CA");
	
		Valuation valuation = highCard.evaluate(hand);
		
		assertEquals(Rank.HIGH_CARD, valuation.getRank());
	}

	@Test
	public void testEvaluateHighCardTieBreaker() {
		Hand hand1 = TestUtils.createHand("C2", "C5", "C3", "CK", "HA");
		Hand hand2 = TestUtils.createHand("D2", "D5", "H3", "SK", "DK");
		
		Valuation v1 = highCard.evaluate(hand1);
		Valuation v2 = highCard.evaluate(hand2);
		
		assertTrue(v1.compareTo(v2) > 0);
	}

	@Test
	public void testEvaluateHighCardEqual() {
		Hand hand1 = TestUtils.createHand("C2", "C5", "C3", "CK", "HA");
		Hand hand2 = TestUtils.createHand("D2", "D5", "D3", "DK", "DA");
		
		Valuation v1 = highCard.evaluate(hand1);
		Valuation v2 = highCard.evaluate(hand2);
		
		assertEquals(v1.compareTo(v2), 0);
	}

	@Test
	public void testEvaluateHighCardLastCardDiffers() {
		Hand hand1 = TestUtils.createHand("C3", "C5", "C4", "CK", "HA");
		Hand hand2 = TestUtils.createHand("D2", "D5", "D4", "DK", "DA");
		
		Valuation v1 = highCard.evaluate(hand1);
		Valuation v2 = highCard.evaluate(hand2);
		
		assertTrue(v1.compareTo(v2) > 0);
	}

}
