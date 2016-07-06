package examples.pokerhands.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
	
	private List<Card> sortedCards = new ArrayList<Card>();

	public Hand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		this.sortedCards.add(card1);
		this.sortedCards.add(card2);
		this.sortedCards.add(card3);
		this.sortedCards.add(card4);
		this.sortedCards.add(card5);
		Collections.sort(this.sortedCards);
	}

	public Card[] getSortedCards() {
		int size = this.sortedCards.size();
		Card[] c = new Card[size];
		return sortedCards.toArray(c);
	}

}
