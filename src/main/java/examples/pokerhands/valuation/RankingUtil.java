package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Suit;
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
	
	static Value find4OfAKind(Hand hand) {
		return findNOfAKind(4, hand, null);
	}
	
	static Value findNOfAKind(int n, Hand hand, Value exceptValue) {
		Card[] cards = hand.getSortedCards();
		
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
	
	static boolean isFlush(Hand hand) {
		Card[] cards = hand.getSortedCards();
		Suit suit = cards[0].getSuit();
		
		for(Card c : cards) {
			if(c.getSuit() != suit) {
				return false;		
			}
		}
		
		return true;
	}
	
	static boolean isStraight(Hand hand) {
		Card[] cards = hand.getSortedCards();

		if (isSuccessor(cards[3], cards[4]) && isSuccessor(cards[2], cards[3]) && isSuccessor(cards[1], cards[2])
				&& isSuccessor(cards[0], cards[1])) {
			return true;
		}

		return false;
	}

	static boolean isSuccessor(Card card, Card successor) {
		return successor.getValue().ordinal() == (card.getValue().ordinal() + 1);
	}

		

}
