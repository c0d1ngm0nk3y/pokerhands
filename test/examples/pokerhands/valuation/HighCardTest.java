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
		Hand hand = TestUtils.createHand("D2", "D5", "H3", "SK", "SK");
	
		Valuation valuation = highCard.evaluate(hand);
		
		assertEquals(Rank.HIGH_CARD, valuation.getRank());
	}

}
