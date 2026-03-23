package firstpart.exceptions;
import firstpart.exceptions.myexceptions.ShortStringException;

public class TestExceptions {
	public static void main(String[] args) {
		try {
			lessThan(2);
		}catch(ShortStringException e) {
			IO.println(e.getMessage());
			IO.println(e.getClass().getSimpleName());
		}
	}
	
	static void lessThan(int number) throws ShortStringException {
		if(number <=3) throw new ShortStringException("The value must be greater than 3");
	}
}