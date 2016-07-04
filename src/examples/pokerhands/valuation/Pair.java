package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;

public class Pair implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		Card[] cards = hand.getCards();
		
		for(int ii = 4; ii > 0; --ii) {
			Card c1 = cards[ii];
			Card c2 = cards[ii - 1];
			
			if(c1.getValue() == c2.getValue()) {
				return new Valuation(Rank.PAIR, c1.getValue(), cards[4].getValue(), cards[3].getValue(), cards[2].getValue(), cards[1].getValue(), cards[0].getValue());
			}
		}
		
		return new Valuation(Rank.NONE);
	}

}
