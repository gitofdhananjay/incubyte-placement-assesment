package calculator;

import custom_exception.StringCalculaterException;

class StringCalculator {

	public int add(String input) throws StringCalculaterException {
   	 	if(input.isEmpty())
    			return 0;
  	  	
	    	return sum(input);
	}

	private int sum(String input) throws StringCalculaterException {
		String delimeter = ",";
		if(input.startsWith("//") && !input.startsWith("//[")) {
			delimeter = input.substring(2, 3);
			input = input.substring(5);
    		}
		if (input.startsWith("//[")) {
			delimeter = input.substring(3, input.indexOf("]"));
			input = input.substring(9);
			}
		input = input.replace(delimeter, ",");
		if(input.contains("\n")) {
    		input = input.replaceAll("\n", ",");
    		
    		}
		String[] srr = input.split(",");
		int sum = 0;
		for(String s : srr) {
			if(Integer.signum(Integer.parseInt(s)) < 0)
				throw new StringCalculaterException("negatives not allowed");
			if(Integer.parseInt(s)>1000)
				continue;
			sum += Integer.parseInt(s);
		}
		return sum;
	}
}