package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;

public class StraightFlush implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		boolean isStraight = RankingUtil.isStraight(hand);
		boolean isFlush = RankingUtil.isFlush(hand);
		
		if(isStraight && isFlush) {
			Card[] cards = hand.getSortedCards();
			return new Valuation(Rank.STRAIGHT_FLUSH, cards[4].getValue());			
		} else {
			return new Valuation(Rank.NONE);		
		}
	}

}
