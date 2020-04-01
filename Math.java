package week1.day2;

public class Math {

	// static variables with access modifier public 
	
	public int add(int a, int b) {
		return a + b;
	}

	public int multiply(int a, int b) {
		return a * b;

	}
	public int div (int a, int b) {
		return a/b;
	}
	
	// create a static method for subraction and call the static method in main class
	
	public static int sub(int a, int b) {
		return a-b;
	}
/*
	public static void main(String[] args) {
		
		Math ref = new Math();
		
		int a=15;
		int b=10;
		
		int sum = ref.add(a, b);
		System.out.println("Output for the sum of two number is :"+sum);
		
		int multiply = ref.multiply(a, b);
		System.out.println("Output for multipling two numbers is :" +multiply);
		
		int div = ref.div(a, b);
		System.out.println("Output for dividing two number is :" +div);
		
	}
*/	
}
