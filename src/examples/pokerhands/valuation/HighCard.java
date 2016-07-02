package examples.pokerhands.valuation;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Value;

public class HighCard implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		return new Valuation(Rank.HIGH_CARD, Value.TWO);
	}

}
