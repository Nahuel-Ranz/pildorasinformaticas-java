package firstpart.exceptions.myexceptions;

public class ShortStringException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ShortStringException() {super();}
	public ShortStringException(String m) {super(m);}
	public ShortStringException(Throwable cause) {super(cause);}
	public ShortStringException(String m, Throwable cause) {
		super(m, cause);
	}
}
