package examples.pokerhands.valuation;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;

public class Straight implements HandRanking {

	@Override
	public Valuation evaluate(Hand hand) {
		Card[] cards = hand.getCards();

		if (isSuccessor(cards[3], cards[4]) && isSuccessor(cards[2], cards[3]) && isSuccessor(cards[1], cards[2])
				&& isSuccessor(cards[0], cards[1])) {
			return new Valuation(Rank.STRAIGHT, cards[4].getValue());
		}

		return new Valuation(Rank.NONE);
	}

	private boolean isSuccessor(Card card, Card successor) {
		return successor.getValue().ordinal() == (card.getValue().ordinal() + 1);
	}

}
