import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class p13 {
	private static ArrayList<String> getData(String filename) {
		try {
			ArrayList<String> numbers = new ArrayList<String>();
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				numbers.add(data);
			}
			myReader.close();
			return numbers;

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {

		// get the data from file
		ArrayList<String> numbers = getData(args[0]);
		System.out.println("size of numbers = " + numbers.get(0).length());
		System.out.println("number of numbers = " + numbers.size());
		System.out.println("value of = " + ('9' - '0'));

		String result = "";
		int sum = 0;
		int carry = 0;

		for (int i = numbers.get(0).length() - 1; i >= 0; i--) {

			for (int j = 0; j < numbers.size(); j++) {
				// numbers_at_pos_i = numbers_at_pos_i + numbers.get(j).charAt(i);
				sum += numbers.get(j).charAt(i) - '0';
			}

			// spit out the number
			carry = (int) Math.floor(sum / 10);
			int digit = sum - (carry * 10);
			result = digit + result;
			// System.out.println(numbers_at_pos_i);
			// System.out.println(result + ": " + sum + " " + digit + " " + carry);

			// carry the carry
			sum = carry;
		}
		result = carry + result;
		System.out.println(result);
	}
}

// p13.test = 52623
