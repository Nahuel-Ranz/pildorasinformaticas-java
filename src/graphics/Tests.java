package graphics;/*
import java.util.Arrays;
import java.util.HashMap;*/

public class Tests {
	public static void main(String []args) {
		String a = "5452424234234234.00000";
		int i = a.indexOf(".");
		IO.println("point index: %d".formatted(i));
		IO.println(a.substring(i));
		IO.println(a.substring(0, i));
		IO.println(a.substring(i).matches("^\\.0*$"));
	}
}