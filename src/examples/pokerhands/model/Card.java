package examples.pokerhands.model;

public class Card implements Comparable<Card> {

	private Suit suit;
	private Value value;

	public Card(String name) {
		if(name.length() != 2) {
			throw new IllegalArgumentException("identifier must have exactly 2 chars");
		}
		
		char s = name.charAt(0);		
		assignSuit(s);
		
		char v = name.charAt(1);		
		assignValue(v);
	}

	private void assignSuit(char s) {
		for(Suit suit : Suit.values()) {
			if(suit.code == s) {
				this.suit = suit;
				return;
			}
		}
		throw new IllegalArgumentException("invalid suit: " + s);
	}

	private void assignValue(char v) {
		for(Value value : Value.values()) {
			if(value.code == v) {
				this.value = value;
				return;
			}
		}
		throw new IllegalArgumentException("invalid value: " + v);
	}

	public Value getValue() {
		return this.value;
	}

	public Suit getSuit() {
		return this.suit;
	}

	@Override
	public int compareTo(Card c) {
		return this.value.compareTo(c.getValue());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public String toString() {
		String string = new String();
		return string + this.suit.code + this.value.code; 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (suit != other.suit)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	
}
