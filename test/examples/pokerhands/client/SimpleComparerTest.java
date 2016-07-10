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

	private String getOutput() {
		return new String(out.toByteArray());
	}
	
	@Test
	public void testValidInput() {
		createInput("S5 S6 S7 S8 S9", "SA DQ DK H4 HJ");
		
		boolean result = comparer.compare2Hands(in, out);
		
		assertTrue(result);
		assertTrue(getOutput().length() > 0);
	}
	
	@Test
	public void testWinnerHandIsPartofOutput() {
		createInput("S5 S6 S7 S8 S9", "SA DQ DK H4 HJ");
		
		boolean result = comparer.compare2Hands(in, out);
		
		assertTrue(result);
		assertTrue(getOutput().contains("S5 S6 S7 S8 S9"));
	}
	
	@Test
	public void testLoserHandIsNotPartofOutput() {
		createInput("S5 S6 S7 S8 S9", "SA DQ DK H4 HJ");
		
		boolean result = comparer.compare2Hands(in, out);
		
		assertTrue(result);
		assertFalse(getOutput().contains("SA DQ DK H4 HJ"));
	}
	
	@Test
	public void testWinningHand2IsPartofOutput() {
		createInput("SA DQ DK H4 HJ", "S5 S6 S7 S8 S9");
		
		boolean result = comparer.compare2Hands(in, out);
		
		assertTrue(result);
		assertFalse(getOutput().contains("SA DQ DK H4 HJ"));
		assertTrue(getOutput().contains("S5 S6 S7 S8 S9"));
	}
	
	@Test
	public void testDeuceHasNoHandInOutput() {
		createInput("D5 D6 D7 D8 D9", "S5 S6 S7 S8 S9");
		
		boolean result = comparer.compare2Hands(in, out);
		
		assertTrue(result);
		assertFalse(getOutput().contains("D5 D6 D7 D8 D9"));
		assertFalse(getOutput().contains("S5 S6 S7 S8 S9"));
	}
	
	@Test
	public void testWinnerHandsRankIsPartofOutput() {
		createInput("S2 S6 S7 S8 S9", "SA DQ DK H4 HJ");
		
		boolean result = comparer.compare2Hands(in, out);
		
		assertTrue(result);
		assertTrue(getOutput().contains("(Flush)"));
	}
	
	@Test
	public void testWinner2ndHandsRankIsPartofOutput() {
		createInput("S2 S6 S7 S8 S9", "SA DA CA HA HJ");
		
		boolean result = comparer.compare2Hands(in, out);
		
		assertTrue(result);
		assertTrue(getOutput().contains("(Four of a kind)"));
	}
	
}
