package custom_exception;

@SuppressWarnings("serial")
public class StringCalculaterException extends Exception {
	
	public StringCalculaterException(String mesg) {
		super(mesg);
	}

}
