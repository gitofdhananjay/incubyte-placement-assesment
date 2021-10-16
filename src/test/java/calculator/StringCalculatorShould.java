package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorShould {
	
	private StringCalculator sCal;
	
	@Before
	public void setup () {
		sCal = new StringCalculator();
	}

    @Test
    public void empty_string_should_return_0() {
        assertEquals(0, sCal.add(""));
    }

    @Test
    public void string_with_single_number_should_return_number_as_int() {
        assertEquals(1, sCal.add("1"));
    }
    
    @Test
    public void string_comma_seperated_numbers_returns_sum_as_int() {
        assertEquals(12, sCal.add("1,5,6"));
    }
    @Test
    public void handles_newLine_returns_sum() {
        assertEquals(12, sCal.add("1,5\n6"));
    }
    
}
