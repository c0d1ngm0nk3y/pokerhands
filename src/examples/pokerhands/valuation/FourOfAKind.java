package examples.pokerhands.valuation;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Value;

public class FourOfAKind implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		Value valueOfFour = RankingUtil.find4OfAKind(hand);
		
		if(null != valueOfFour) {
			return new Valuation(Rank.FOUR_KIND, valueOfFour);
		}
		else {
			return new Valuation(Rank.NONE);			
		}
	}

}
