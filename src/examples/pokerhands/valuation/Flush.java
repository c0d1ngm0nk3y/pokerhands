package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Suit;

public class Flush implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		
		Card[] cards = hand.getCards();
		Suit suit = cards[0].getSuit();
		
		for(Card c : cards) {
			if(c.getSuit() != suit) {
				return new Valuation(Rank.NONE);		
			}
		}

		return new Valuation(Rank.FLUSH, cards[0].getValue(), cards[1].getValue(), cards[2].getValue(), cards[3].getValue(), cards[4].getValue());
	}

}
