package examples.pokerhands.client;

import static org.junit.Assert.*;

import org.junit.Test;

import examples.pokerhands.model.Card;
import examples.pokerhands.model.Hand;

public class ParserTest {

	Parser parser = new Parser();
	Hand hand = null;
	
	@Test(expected=IllegalArgumentException.class)
	public void testParseEmptyString() {
		hand = parser.parseHand("");
	}

	@Test
	public void testParseSimpleHand() {
		hand = parser.parseHand("H2 H3 H4 H5 H6");
		
		assertNotEquals(null, hand);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testParseTooFewCards() {
		hand = parser.parseHand("H2 H3 H4 H5");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testParseTooManyCards() {
		hand = parser.parseHand("H2 H3 H4 H5 H6 H7");
	}

	@Test
	public void testParseSimpleHandWithBlanks() {
		hand = parser.parseHand(" H2  H3   H4 H5   H6");
		
		assertNotEquals(null, hand);
	}

	@Test
	public void testParseSimpleCorrectHand() {
		hand = parser.parseHand("H2 H3 H4 H5 HT");
		Card ht = new Card("HT");
		Card h5 = new Card("H5");
		Card h4 = new Card("H4");
		Card h3 = new Card("H3");
		Card h2 = new Card("H2");
		
		assertEquals(ht, hand.getSortedCards()[4]);
		assertEquals(h5, hand.getSortedCards()[3]);
		assertEquals(h4, hand.getSortedCards()[2]);
		assertEquals(h3, hand.getSortedCards()[1]);
		assertEquals(h2, hand.getSortedCards()[0]);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testParseNotExistingCard() {
		hand = parser.parseHand("H2 H3 H4 H5 H6 HX");
	}

	@Test
	public void testParseLowerCase() {
		hand = parser.parseHand("s7 h5 dq ca sk");
		
		assertNotEquals(null, hand);
	}
	
}
