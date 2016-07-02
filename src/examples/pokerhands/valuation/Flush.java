package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Suit;
import examples.pokerhands.model.Value;

public class Flush implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		
		Card[] cards = hand.getCards();
		Suit suit = cards[0].getSuit();
		
		for(Card c : cards) {
			if(c.getSuit() != suit) {
				return new Valuation(Rank.NONE, Value.TWO);		
			}
		}
		
		return new Valuation(Rank.FLUSH, Value.TWO);
	}

}
