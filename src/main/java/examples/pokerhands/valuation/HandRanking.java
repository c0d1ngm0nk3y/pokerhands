package examples.pokerhands.valuation;

import examples.pokerhands.model.Hand;

public interface HandRanking {

	public Valuation evaluate(Hand hand);
	
}
