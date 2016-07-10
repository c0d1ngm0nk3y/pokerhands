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
		Parser parser = new Parser();
		
		try {
			writer.write("Enter hand 1: ");
			writer.flush();
			String line1 = reader.readLine();
			if(null == line1) {
				line1 = "";
			}
			Hand hand1 = parser.parseHand(line1);
			Valuation v1 = rater.rate(hand1);
			
			writer.write("Enter hand 2: ");
			writer.flush();
			String line2 = reader.readLine();
			if(null == line2) {
				line2 = "";
			}
			Hand hand2 = parser.parseHand(line2);
			Valuation v2 = rater.rate(hand2);
			
			int result = v1.compareTo(v2);
			
			if(result > 0) {
				writer.write("Winning hand: ");
				writer.write(hand1.toString());
				writer.write(" (" + v1.getRank().toString() + ")");
			} else if(result < 0) {
				writer.write("Winning hand: ");
				writer.write(hand2.toString());
				writer.write(" (" + v2.getRank().toString() + ")");
			} else {
				writer.write("No winning hand");
			}
			writer.write("\n\n");
			writer.flush();
		} catch (Exception e) {
			try {
				writer.write("Exception:" + e);
				writer.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		//FIXME close resource
		
		return true;
	}

}
