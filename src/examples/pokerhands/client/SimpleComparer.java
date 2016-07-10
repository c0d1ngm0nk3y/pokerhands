package examples.pokerhands.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import examples.pokerhands.model.Hand;
import examples.pokerhands.valuation.Rater;
import examples.pokerhands.valuation.Valuation;

public class SimpleComparer {

	private Rater rater;

	public SimpleComparer() {
		super();
		rater = new Rater();
		rater.registerAll();
	}

	public boolean compare2Hands(InputStream in, OutputStream out) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		
		try {
			Hand hand1 = readHand(reader, writer, 1);
			Valuation v1 = rater.rate(hand1);
			
			Hand hand2 = readHand(reader, writer, 2);
			Valuation v2 = rater.rate(hand2);
			
			int result = v1.compareTo(v2);
			
			if(result > 0) {
				reportWinner(writer, hand1, v1);
			} else if(result < 0) {
				reportWinner(writer, hand2, v2);
			} else {
				reportNoWinner(writer);
			}

			writeEnd(writer);
		} catch (Exception e) {
			try {
				reportException(writer, e);
			} catch (IOException io) {
				io.printStackTrace();
			}
			return false;
		}
		
		return true;
	}

	private void reportException(BufferedWriter writer, Exception e) throws IOException {
		writer.write("An error occured:" + e.getMessage() + "\n");
		writer.flush();
	}

	private void writeEnd(BufferedWriter writer) throws IOException {
		writer.write("\n\n");
		writer.flush();
	}

	private void reportNoWinner(BufferedWriter writer) throws IOException {
		writer.write("No winning hand");
	}

	private void reportWinner(BufferedWriter writer, Hand hand, Valuation value) throws IOException {
		writer.write("Winning hand: ");
		writer.write(hand.toString());
		writer.write(" (" + value.getRank().toString() + ")");
	}

	private Hand readHand(BufferedReader reader, BufferedWriter writer, int number) throws IOException {
		writer.write("Enter hand " + number + ": ");
		writer.flush();
		String line = reader.readLine();
		if(null == line) {
			line = "";
		}
		
		Hand hand = new Parser().parseHand(line);
		return hand;
	}

}
