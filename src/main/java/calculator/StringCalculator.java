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
		String delimeter = ",";
		if(input.startsWith("//")) {
			delimeter = input.substring(2, 3);
			input = input.substring(5);
    		}
		if(input.contains("\n")) {
    		input = input.replaceAll("\n", delimeter);
    		
    		}
		String[] srr = input.split(delimeter);
		int sum = 0;
		for(String s : srr) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}
}