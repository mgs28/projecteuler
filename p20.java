import java.math.BigInteger;

public class p20{


	// let's go fast using java built in library
	private static int sumOfDigits(int n) {
        BigInteger sum = new BigInteger(n+"");
        n = n - 1;
        while(n>0){
            sum = sum.multiply(new BigInteger(n+""));
            n = n - 1;
        }
		
        System.out.println(sum);
        
        return (sum.toString()
				.chars().map(c -> (c - 48))
				.reduce(0, Integer::sum));
	}

    public static void main(String args[]){
        System.out.println("Hello, world!");
        System.out.println(sumOfDigits(100));
    }
}