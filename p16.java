import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.math.BigInteger;

public class p16 {

	private static ArrayList<Integer> mult2(ArrayList<Integer> x) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		Collections.reverse(x);

		int carry = 0;
		for (int i : x) {
			int y = (i * 2) + carry;
			int r = y % 10;
			carry = (y - r) / 10;
			// System.out.println("..." + i + "\ty="+y+"\tr="+r+"\tcarry="+carry);
			result.add(r);
		}
		if (carry > 0) {
			result.add(carry);
		}

		Collections.reverse(result);
		return result;
	}

	// let's go fast using java built in library
	private static int sumOfDigits(int n) {

		return (new BigInteger("2").pow(1000).toString()
				.chars().map(c -> (c - 48))
				.reduce(0, Integer::sum));

	}

	public static void main(String[] args) {
		/*
		 * Given 2**k, convert to decimal
		 * 1. We can gradually multiply by 2
		 * 2. Can do something with binary representation?
		 * 3. Does base 100 or base 1000 help us?
		 * 
		 * 
		 */

		/*
		 * System.out.println(mult2(new ArrayList<Integer>(List.of(1,2))));
		 * System.out.println(mult2(new ArrayList<Integer>(List.of(2))));
		 * System.out.println(mult2(new ArrayList<Integer>(List.of(2,9))));
		 * System.out.println(mult2(new ArrayList<Integer>(List.of(3,0))));
		 * System.out.println(mult2(new ArrayList<Integer>(List.of(9,4))));
		 * System.out.println(mult2(new ArrayList<Integer>(List.of(9,9,9))));
		 */

		ArrayList<Integer> product = new ArrayList<Integer>(List.of(1));
		for (int i = 0; i < 1000; i++) {
			product = mult2(product);
		}
		// System.out.println(product);

		int sum = 0;
		for (int i : product) {
			sum = sum + i;
		}
		System.out.println(sum);
		System.out.println(sumOfDigits(1000));

	}
}
