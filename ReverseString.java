package week1.day3;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "welcome";

		char[] newtext = text.toCharArray();
		
		// to get the lenth of the text where length() is java method
		int j = text.length()-1;

		for (int i = 0; i <= j; j--) {
			
			System.out.print(newtext[j]);
		}
	}

}
