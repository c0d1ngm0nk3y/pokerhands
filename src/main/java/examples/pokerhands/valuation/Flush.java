package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;

public class Flush implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		
		boolean isFlash = RankingUtil.isFlush(hand);
		
		if(isFlash) {
			Card[] cards = hand.getSortedCards();
			return new Valuation(Rank.FLUSH, cards[4].getValue(), cards[3].getValue(), cards[2].getValue(), cards[1].getValue(), cards[0].getValue());			
		}
		else {
			return new Valuation(Rank.NONE);
		}

	}


}
