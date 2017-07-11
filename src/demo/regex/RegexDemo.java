package demo.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	
	public static void validate() {
		List<String> input = new ArrayList<String>();
		input.add("123-45-6789");
		input.add("9876-5-4321");
		input.add("987-65-4321 (attack)");
		input.add("987-65-4321 ");
		input.add("192-83-7465");


		for (String ssn : input) {
			if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
				System.out.println("Found good SSN: " + ssn);
			}
		}
	}
	
	public static void replace() {
		String input = "User clientId=23421. Some more text clientId=33432. This clientNum=100";

		Pattern p = Pattern.compile("(clientId=)(\\d+)");
		Matcher m = p.matcher(input);
		
		StringBuffer result = new StringBuffer();
		while (m.find()) {
			System.out.println("Masking: " + m.group(2));
			m.appendReplacement(result, m.group(1) + "***masked***");
			System.out.println(result.toString());
		}
		m.appendTail(result);
		System.out.println(result);
	}

	public static void main(String[] args) {
		validate();
		replace();
	}

}
