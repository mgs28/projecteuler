import java.util.ArrayList;

class p21{
    
    private static ArrayList<Integer> findProperDivisors(int n){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        
        int numbers[] = new int[n+1];
        
        //all numbers are divisible by 1
        for(int i=0;i<=n;i++){
            numbers[i] = 1;
        }

        for(int i=2; i<=n;i++){ 
            //all numbers are divisible by themselves 
            //numbers[i] = numbers[i] + i;

            //for all multiples of this number toggle the number as not prime
            for(int j = i + i; j <= n; j=j+i){
                numbers[j] = numbers[j]+i;
            }

        }

        int sum = 0;
        for(int i=2;i<n;i++){

            if(numbers[i] < n && i == numbers[numbers[i]] && i < numbers[i]){
                System.out.println("i " + i + " numbers[i] " + numbers[i]);
                sum = sum + i;
                sum = sum + numbers[i];
            }
        }
        System.out.println("sum = " + sum);
        return primes;
    }    

    public static void main(String args[]){
       
        
        int n = 10000;

        //find our primes 
        ArrayList<Integer> primes = findProperDivisors(n); 
        //31626

    }
}