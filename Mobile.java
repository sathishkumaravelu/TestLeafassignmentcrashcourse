package week1.day1;

public class Mobile {

	public static void main(String[] args) {
		System.out.println("I am ready :LGS");
	
		Mobile ref= new Mobile();
		
		boolean Currentstate = ref.status;
		int currentage = ref.ageofmobile;
		String mobilemod = ref.MobileModel;
		
		System.out.println("currently moble modle : " +mobilemod);
		System.out.println("currently moble display on: " +Currentstate);
		System.out.println("currently age of mobile: " +currentage);
		
	}
	
	boolean status = true;

	int ageofmobile =2;
	
	String MobileModel="OnePlus";
	
}
