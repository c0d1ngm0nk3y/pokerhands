package examples.pokerhands.model;

import java.util.SortedSet;
import java.util.TreeSet;

public class Hand {
	
	private SortedSet<Card> cards = new TreeSet<Card>();

	public Hand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		this.cards.add(card1);
		this.cards.add(card2);
		this.cards.add(card3);
		this.cards.add(card4);
		this.cards.add(card5);
	}

	public Card[] getCards() {
		int size = this.cards.size();
		Card[] c = new Card[size];
		return cards.toArray(c);
	}

}
