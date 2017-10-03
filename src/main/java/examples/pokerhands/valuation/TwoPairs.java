package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Value;

public class TwoPairs implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		Value valueOfPair1 = RankingUtil.findPair(hand);
		Value valueOfPair2 = RankingUtil.findPair(hand, valueOfPair1);
		Card[] cards = hand.getSortedCards();
		
		if(null != valueOfPair2) {
			return new Valuation(Rank.TWO_PAIRS, valueOfPair1, valueOfPair2, cards[4].getValue(), cards[3].getValue(), cards[2].getValue(), cards[1].getValue(), cards[0].getValue());
		}
		else {
			return new Valuation(Rank.NONE);			
		}
	}

}
