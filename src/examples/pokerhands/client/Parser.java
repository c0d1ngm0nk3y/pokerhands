package examples.pokerhands.client;

import examples.pokerhands.model.Hand;
//FIXME TestUtils
import examples.pokerhands.model.TestUtils;

public class Parser {

	public Hand parseHand(String input) {
		
		String[] cards = getValidatedCardStrings(input);
		
		if(cards.length == 5) {
			return TestUtils.createHand(cards[0], cards[1], cards[2], cards[3], cards[4]);
		}
		
		throw new IllegalArgumentException("Could not parse Hand: <" + input + ">");
	}

	private String[] getValidatedCardStrings(String input) {
		String[] cards = input.replaceAll("  +", " ").trim().toUpperCase().split(" ");
		return cards;
	}

}
