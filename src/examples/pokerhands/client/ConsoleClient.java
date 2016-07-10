package examples.pokerhands.client;

public class ConsoleClient {

	public static void main(String[] args) {
		
		boolean result = false;
		SimpleComparer comparer = new SimpleComparer();
		
		do {
			result = comparer.compare2Hands(System.in, System.out);
		} while(result);

	}

}
