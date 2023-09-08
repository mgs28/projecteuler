
public class p17 {

	private static String[] lessThan20 = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	private static String[] tensPlaces = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	// let's do it with recursion!
	private static String writtenNumber(int n) {

		if (n == 0) {
			return "";
		} else if (n == 1000) {
			return "onethousand";
		} else if (n < 20) {
			return lessThan20[n];
		} else if (n < 100) {
			int tensPlace = (int) (n / 10);

			return tensPlaces[tensPlace] + "" + writtenNumber(n - (tensPlace * 10));
		}

		int hundredsPlace = (int) (n / 100);

		return lessThan20[hundredsPlace] + "hundred" + (n % 100 == 0 ? "" : "and")
				+ writtenNumber(n - (hundredsPlace * 100));

	}

	public static void main(String[] args) {

		int[] testArray = { 1, 10, 30, 35, 115, 135, 342, 535 };
		String[] comparison = { "one", "ten", "thirty", "thirtyfive", "onehundredandfifteen", "onehundredandthirtyfive",
				"threehundredandfortytwo", "fivehundredandthirtyfive" };

		for (int i = 0; i < testArray.length; i++) {
			String temp = writtenNumber(testArray[i]);
			if (comparison[i].equals(temp)) {
				// System.out.println(testArray[i] + " = " + comparison[i] + " " +
				// comparison[i].length());
			} else {
				System.out.println(
						"error! " + testArray[i] + " = " + comparison[i] + "!=" + temp + " " + comparison[i].length());
			}
		}

		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			String temp = writtenNumber(i);
			sum = sum + temp.length();
			System.out.println(i + " " + temp);
		}
		System.out.println(sum);

	}
}
