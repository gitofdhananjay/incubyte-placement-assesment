package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import custom_exception.StringCalculaterException;

class StringCalculator {

	public int add(String input) throws StringCalculaterException {
   	 	if(input.isEmpty())
    			return 0;
   		return sum(input);
   		
	}
	private int sum(String input) throws StringCalculaterException {

		String str = input;
		Pattern pattern = Pattern.compile("-?[0-9]+");
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()) {
		    int value = Integer.parseInt(matcher.group());
		    if (value< 0)
		    	throw new StringCalculaterException("negatives not allowed");
		    }

		int sum = 0;
		Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(input);
        while(m.find() && sum<1000) {
   
			if(Integer.parseInt(m.group())>1000)
				continue;
			sum += (Integer.parseInt(m.group()));
		}
		return sum;
	}
}