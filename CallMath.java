package week1.day2;

public class CallMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=15;
		
		/*since its not an static method we need to create 
		object for the method and then need to access*/
		
		Math ref = new Math();
		int add = ref.add(a, b);
		int div = ref.div(a, b);
		int multiply = ref.multiply(a, b);
		
		/*we need not want to create reference object to access 
		 * static method directly we can access classname.methodname()*/
		
		int sub = Math.sub(a, b);
		
		System.out.println("the output for addition of two number is :" +add);
		System.out.println("the output for addition of two number is :" +div);
		System.out.println("the output for addition of two number is :" +multiply);
		System.out.println("the output for addition of two number is :" +sub);
		
	}

}
