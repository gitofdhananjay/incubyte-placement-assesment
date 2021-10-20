package calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import custom_exception.StringCalculaterException;

public class StringCalculatorShould {
	
	private StringCalculator sCal;
	
	@Before
	public void setup () {
		sCal = new StringCalculator();
	}

    @Test
    public void empty_string_should_return_0() throws StringCalculaterException {
        assertEquals(0, sCal.add(""));
    }

    @Test
    public void string_with_single_number_should_return_number_as_int() throws StringCalculaterException {
        assertEquals(1, sCal.add("1"));
    }
    
    @Test
    public void string_comma_seperated_numbers_returns_sum_as_int() throws StringCalculaterException {
        assertEquals(12, sCal.add("1,5,6"));
        assertEquals(37 ,sCal.add("1,5,3,6,4,6,8,4"));
    }
    
    @Test
    public void handles_newLine_returns_sum() throws StringCalculaterException {
        assertEquals(12, sCal.add("1,5\n6"));
        assertEquals(37 ,sCal.add("1,5,3\n6,4,6,8\n\n4"));
    }
    
    @Test
    public void support_different_delimeters() throws StringCalculaterException {
        assertEquals(3, sCal.add("//;\\n1;2"));
        assertEquals(40, sCal.add("//;\\n1;2,1,5,3\\n6,4,6,8\\n\\n4"));
    }
    
    @Test
    public void handles_negative_number() {	
        	assertThrows(StringCalculaterException.class , ()-> sCal.add("1,5\n-6"));
        	
    }
   
    @Test
    public void skips_if_more_than_1000() throws StringCalculaterException {
        assertEquals(32, sCal.add("1,5\n6,20\n1001"));
        
    }
    @Test
    public void handles_any_length_delimeter() throws StringCalculaterException {
       assertEquals(7, sCal.add("//[***]\\n1***3***3***1002"));
      
   }
    @Test
    public void handles_two_delimeter() throws StringCalculaterException {
       assertEquals(6, sCal.add("//[*][%]\\n1*2%3"));
     
   }
    @Test
    public void handles_any_length_two_delimeter() throws StringCalculaterException {
       assertEquals(6, sCal.add("//[******][%%%%%%]\\n1*2%3"));
       
   }
    @Test
    public void no_more_sum_par_thousand() throws StringCalculaterException {
       assertEquals(1010, sCal.add("999,11,1000, 2000"));
      
   }
  
}
