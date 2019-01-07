package regexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testRegex {

	public static void main(String[] args) {
		String email ="ghanim.w@gamil.com";
		String regex ="[\\w\\.?]{2,}\\@\\w{2,}\\.[\\a-zA-Z]{2,3}";
		String txt= "b be bee beer beers";
		String suchPattern="\\w{3,}";
		
		System.out.println(email.matches(regex));
		
//		Pattern pat = Pattern.compile(suchPattern);
//		Matcher m = pat.matcher(txt);
//		
//		
//		
//		while (m.find()) {
//			System.out.println(m.group());
//		}
	}
}
