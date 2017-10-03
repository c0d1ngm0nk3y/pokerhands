package examples.pokerhands.model;

public enum Suit {
	CLUBS('C'),
	DIAMONDS('D'),
	HEARTS('H'),
	SPADES('S');
	
	public char code;
	
	Suit(char _code) {
		this.code = _code;
	}
}
