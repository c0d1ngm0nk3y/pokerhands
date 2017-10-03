package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;

public class HighCard implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		Card[] cards = hand.getSortedCards();
		return new Valuation(Rank.HIGH_CARD, cards[4].getValue(), cards[3].getValue(), cards[2].getValue(), cards[1].getValue(), cards[0].getValue());
	}

}
