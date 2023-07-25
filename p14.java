import java.util.HashMap;

public class p14 {

	private static long collatz_num(long n, HashMap<Long, Long> m) {

		// use m
		if (m.containsKey(n)) {
			return m.get(n);
		} else if (n == 1) {
			return 1;
		} else if (n <= 0) {
			System.out.println(n + " <= 0");
			System.exit(1);
		}

		// we don't know this answer
		long collatz_n = -1;
		if (n % 2 == 0) {
			collatz_n = collatz_num(n / 2, m) + 1;
		} else {
			collatz_n = collatz_num((3 * n) + 1, m) + 1;
		}

		m.put(n, collatz_n);
		return collatz_n;
	}

	public static void main(String[] args) {
		HashMap<Long, Long> m = new HashMap<Long, Long>();

		// Stack<Long> s = collatz(13);
		// System.out.println(collatz_num(13,m));
		// System.out.println(collatz(113383));
		// System.out.println(collatz_num(113383,m));

		long max_collatz = -1;
		long max_collatz_i = -1;
		for (long i = 1; i <= 1000000; i++) {
			long temp = collatz_num(i, m);
			// System.out.println("collatz("+i+"): " + temp);
			if (temp > max_collatz) {
				max_collatz = temp;
				max_collatz_i = i;
			}
		}

		System.out.println("i=" + max_collatz_i + " has a collatz num of " + max_collatz);

	}
}
