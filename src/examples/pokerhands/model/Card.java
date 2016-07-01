package examples.pokerhands.model;

public class Card {

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

}
