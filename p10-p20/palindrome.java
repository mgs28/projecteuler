public class palindrome{
    
    private static boolean IsPalindrome(int x){
        String f = x + "";
        String r = "";
        for(char c : f.toCharArray()){
            r = c + r;
        }
        return f.equals(r);
    }
    
    public static void main(String args[]){
        System.out.println(IsPalindrome(101));
        System.out.println(IsPalindrome(-101));
    }
}