package examples.pokerhands.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
			String line1 = reader.readLine();
			Hand hand1 = parser.parseHand(line1);
			Valuation v1 = rater.rate(hand1);
			
			String line2 = reader.readLine();
			Hand hand2 = parser.parseHand(line2);
			Valuation v2 = rater.rate(hand2);
			
			int result = v1.compareTo(v2);
			
			if(result > 0) {
				out.write(hand1.toString().getBytes());
			} else if(result < 0) {
				out.write(hand2.toString().getBytes());		
			} else {
				out.write("No winning hand".getBytes());
			}
			
			writer.flush();
		} catch (Exception e) {
			return false;
		}
		//FIXME close resource
		
		return true;
	}

}
