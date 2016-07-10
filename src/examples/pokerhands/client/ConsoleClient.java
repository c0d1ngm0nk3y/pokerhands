package examples.pokerhands.client;

public class ConsoleClient {

	public static void main(String[] args) {
		
		boolean result = false;
		SimpleComparer comparer = new SimpleComparer();
		System.out.println("See https://github.com/c0d1ngm0nk3y/pokerhands/blob/master/README.md for details\n\n");
		
		do {
			result = comparer.compare2Hands(System.in, System.out);
		} while(result);

	}

}
