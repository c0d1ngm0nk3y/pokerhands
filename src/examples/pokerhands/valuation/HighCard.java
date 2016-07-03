package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;
import examples.pokerhands.model.Value;

public class HighCard implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		Card[] cards = hand.getCards();
		return new Valuation(Rank.HIGH_CARD, cards[0].getValue(), cards[1].getValue(), cards[2].getValue(), cards[3].getValue(), cards[4].getValue());
	}

}
