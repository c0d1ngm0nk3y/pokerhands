package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Value;

public class Pair implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		
		Value valueOfPair = RankingUtil.findPair(hand);
		Card[] cards = hand.getSortedCards();
		
		if(null != valueOfPair) {
			return new Valuation(Rank.PAIR, valueOfPair, cards[4].getValue(), cards[3].getValue(), cards[2].getValue(), cards[1].getValue(), cards[0].getValue());
		}
		else {
			return new Valuation(Rank.NONE);			
		}
		
	}

}
