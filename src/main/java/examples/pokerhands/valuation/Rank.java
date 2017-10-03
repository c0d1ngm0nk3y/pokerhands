package examples.pokerhands.valuation;

public enum Rank {
	NONE,
	HIGH_CARD,
	PAIR,
	TWO_PAIRS,
	THREE_KIND,
	STRAIGHT,
	FLUSH,
	FULL_HOUSE,
	FOUR_KIND,
    STRAIGHT_FLUSH;

	@Override
	public String toString() {
		switch(this) {
		case NONE:
			return "No ranking";
		case HIGH_CARD:
			return "High Card";
		case PAIR:
			return "Pair";
		case TWO_PAIRS:
			return "Two Pairs";
		case THREE_KIND:
			return "Three of a kind";
		case STRAIGHT:
			return "Straight";
		case FLUSH:
			return "Flush";
		case FULL_HOUSE:
			return "Full House";
		case FOUR_KIND:
			return "Four of a kind";
		case STRAIGHT_FLUSH:
			return "Straight Flush";
		default:
			throw new IllegalStateException("Unknown Ranking");
		}
	}
}
