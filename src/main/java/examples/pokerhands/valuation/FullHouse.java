package examples.pokerhands.valuation;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Value;

public class FullHouse implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		Value valueOfThree = RankingUtil.find3OfAKind(hand);
		Value valueOfPair = RankingUtil.findPair(hand, valueOfThree);
		
		boolean threeOfAKind = null != valueOfThree;
		boolean pair = null != valueOfPair;
		if(threeOfAKind && pair) {
			return new Valuation(Rank.FULL_HOUSE, valueOfThree);
		}
		else {
			return new Valuation(Rank.NONE);			
		}
	}

}
