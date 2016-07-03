package examples.pokerhands.valuation;

import java.util.ArrayList;
import java.util.List;

import examples.pokerhands.model.Value;

public class Valuation implements Comparable<Valuation> {
	
	private Rank rank = Rank.NONE;
	private List<Value> tieBreakers = new ArrayList<Value>();

	public Valuation(Rank rank, Value... tieBreakers) {
		this.rank = rank;
		for(Value v : tieBreakers) {
			this.tieBreakers.add(v);
		}
	}

	@Override
	public int compareTo(Valuation that) {
		int result;
		result =  this.rank.compareTo(that.rank);
		
		if(0 == result) {
			result = compareTieBreakers(that);
		}
		
		return result;
	}

	private int compareTieBreakers(Valuation that) {
		int result = 0;
		int numberOfTieBreakers = Math.min(this.tieBreakers.size(), that.tieBreakers.size());
		
		for(int ii = 0; ii < numberOfTieBreakers; ++ii) {
			result = this.tieBreakers.get(ii).compareTo(that.tieBreakers.get(ii));	
			if(result != 0) {
				break;
			}
		}
		return result;
	}

	public Rank getRank() {
		return this.rank;
	}

}
