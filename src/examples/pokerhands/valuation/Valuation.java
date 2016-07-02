package examples.pokerhands.valuation;

import examples.pokerhands.model.Value;

public class Valuation implements Comparable<Valuation> {
	
	private Rank rank = Rank.NONE;
	private Value tieBreaker = Value.TWO;

	public Valuation(Rank rank, Value tieBreaker) {
		this.rank = rank;
		this.tieBreaker = tieBreaker;
	}

	@Override
	public int compareTo(Valuation that) {
		int result;
		result =  this.rank.compareTo(that.rank);
		
		if(0 == result) {
		   result = this.tieBreaker.compareTo(that.tieBreaker);	
		}
		
		return result;
	}

	public Rank getRank() {
		return this.rank;
	}

}
