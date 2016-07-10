package examples.pokerhands.client;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class SimpleComparerTest {

	SimpleComparer comparer = new SimpleComparer();
	InputStream in = null;
	ByteArrayOutputStream out =  new ByteArrayOutputStream();
	
	
	@Test
	public void testEmptyInput() {
		createInput("", "");
		
		boolean result = comparer.compare2Hands(in, out);
		
		assertFalse(result);
	}

	private void createInput(String line1, String line2) {
		String input = line1 + "\n" + line2 +"\n";
		in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	}
	
	@Test
	public void testValidInput() {
		createInput("S5 S6 S7 S8 S9", "SA DQ DK H4 HJ");
		
		boolean result = comparer.compare2Hands(in, out);
		
		assertTrue(result);
		assertTrue(out.toByteArray().length > 0);
	}
	
}
