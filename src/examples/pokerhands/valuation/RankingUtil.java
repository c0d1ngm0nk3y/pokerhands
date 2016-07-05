package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Value;

public class RankingUtil {
	
	static Value findPair(Hand hand) {
		return findPair(hand, null);
	}

	static Value findPair(Hand hand, Value exceptValue) {
		return findNOfAKind(2, hand, exceptValue);
	}

	static Value find3OfAKind(Hand hand) {
		return findNOfAKind(3, hand, null);
	}
	
	static Value findNOfAKind(int n, Hand hand, Value exceptValue) {
		Card[] cards = hand.getCards();
		
		int x = n - 1;
		for(int ii = 4; ii >= x; --ii) {
			Card c1 = cards[ii];
			Card c2 = cards[ii - x];
			
			boolean validPair = c1.getValue() != exceptValue;
			boolean isPair = c1.getValue() == c2.getValue();
			
			if(isPair && validPair) {
				return c1.getValue();
			}
		}
		
		return null;
	}
		

}
