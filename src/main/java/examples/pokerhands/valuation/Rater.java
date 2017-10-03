package examples.pokerhands.valuation;

import java.util.ArrayList;
import java.util.List;

import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Value;

public class Rater {
	
	List<HandRanking> rankings = new ArrayList<HandRanking>();

	public Valuation rate(Hand hand) {
		Valuation valuation = new Valuation(Rank.NONE, Value.TWO);

		for(HandRanking r : rankings) {
			Valuation v = r.evaluate(hand);
			if(v.compareTo(valuation) > 0) {
				valuation = v;
			}
		}
		
		return valuation;
	}

	public void register(HandRanking ranking) {
		this.rankings.add(ranking);
	}

	public void registerAll() {
		register(new HighCard());
		register(new Pair());
		register(new TwoPairs());
		register(new ThreeOfAKind());
		register(new Straight());
		register(new Flush());
		register(new FullHouse());
		register(new FourOfAKind());
		register(new StraightFlush());
	}

}
