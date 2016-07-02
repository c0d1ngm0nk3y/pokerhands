package examples.pokerhands.valuation;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;

public class HighCardTest {
	
	private HandRanking highCard = new HighCard();

	@Test
	public void testEvaluateHighCard() {
		Hand hand = new Hand(new Card("D2"), new Card("D5"), new Card("H3"), new Card("SK"), new Card("SK"));
		
		Valuation valuation = highCard.evaluate(hand);
		
		assertEquals(Rank.HIGH_CARD, valuation.getRank());
	}

}
