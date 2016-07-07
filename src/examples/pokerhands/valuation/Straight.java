package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;

public class Straight implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		boolean isStraight = RankingUtil.isStraight(hand);
		
		if(isStraight) {
			Card[] cards = hand.getSortedCards();
			return new Valuation(Rank.STRAIGHT, cards[4].getValue());			
		} else {
			return new Valuation(Rank.NONE);		
		}
	}

}
