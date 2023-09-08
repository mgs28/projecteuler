public class p15{

    public static double factorial(int f){
	if(f==1){
	    return 1;
	}
	
	return f * factorial(f-1);
	    
    }
	
    public static double lattice_paths(int n){
	//problem reduces to I have 2*n moves of which n have to be RIGHT and n have to be DOWN
	//So I have to choose n of 2*n indices as RIGHT

	return factorial(2*n) / (factorial(n)*factorial(n));
    }
    
    public static void main(String[] args){

	System.out.println("Hello, world!");

	System.out.println(lattice_paths(2));
	System.out.println(lattice_paths(3));
	System.out.println(lattice_paths(20));
    }
}
