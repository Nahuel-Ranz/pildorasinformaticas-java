package firstpart.graphics;

import java.util.ArrayList;
import java.util.ListIterator;

public class Iterators {
	public static void main(String[] args) {
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("Argentina");
		countries.add("Suiza");
		countries.add("Suecia");
		countries.add("Paraguay");
		countries.add("Uruguay");
		countries.add("Chile");
		countries.add("Peru");
		
		ListIterator<String> it = countries.listIterator();
		
		IO.println(it.next());
		IO.println(it.previous());
		IO.println(it.previous());
	}
}