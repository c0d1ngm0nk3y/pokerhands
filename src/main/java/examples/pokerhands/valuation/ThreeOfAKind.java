package examples.pokerhands.valuation;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Value;

public class ThreeOfAKind implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		Value valueOfThree = RankingUtil.find3OfAKind(hand);
		
		if(null != valueOfThree) {
			return new Valuation(Rank.THREE_KIND, valueOfThree);
		}
		else {
			return new Valuation(Rank.NONE);			
		}
	}

}
