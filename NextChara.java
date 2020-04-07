package week1.day3;

public class NextChara {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// input string
		String text = "A1B2C3";
		System.out.println("Input string is :" + text);
		for (int i = 0; i <= text.length() - 1; i++) {

			char asicValue = text.charAt(i); // convert the string into character

			// System.out.print(asicValue);

			/*
			 * convert char to int(syntax: int variablename = refvaribable) and adding +1 to
			 * the value and store in an integer
			 */

			int newString = asicValue + 1;

			// System.out.println(newString);

			/*
			 * now converting the integer to the equalent character using type casting
			 * syntax: char variable = (char) integer
			 */

			char ch = (char) newString;
			System.out.print(ch);

			// char newString = (char) ((text.charAt(i)) + 1);
			// System.out.print(newString);

		}

	}

}
