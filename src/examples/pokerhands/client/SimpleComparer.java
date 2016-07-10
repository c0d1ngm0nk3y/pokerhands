package examples.pokerhands.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class SimpleComparer {

	public boolean compare2Hands(InputStream in, OutputStream out) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
		Parser parser = new Parser();
		
		try {
			String line1 = reader.readLine();
			parser.parseHand(line1);
			
			String line2 = reader.readLine();
			parser.parseHand(line2);
			
			writer.write(line1);
			writer.write(line2);
			writer.flush();
		} catch (Exception e) {
			return false;
		}
		//finally {
			//reader.close();
		//}
		
		
		return true;
	}

}
