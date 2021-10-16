package calculator;

import custom_exception.StringCalculaterException;

class StringCalculator {
	String delimeter = ",";

    public int add(String input) {
    	if(input.isEmpty())
    		return 0;
    	
    	return sum(input);
    	
    		
    }
    private int sum(String input) {	
		String[] srr = input.split(",");
		int sum = 0;
		for(String s : srr) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}
}