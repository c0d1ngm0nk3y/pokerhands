package examples.pokerhands.model;

public class TestUtils {

	public static Hand createHand(String c1, String c2, String c3, String c4, String c5) {
		Hand hand = new Hand(new Card(c1), new Card(c2), new Card(c3), new Card(c4), new Card(c5));
		return hand;
	}

}
