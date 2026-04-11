package secondpart.collections.library;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		try {
			
			Set<Book> library = new HashSet<Book>();
			library.add(new Book("a", "b", "1"));
			
			IO.println(library.contains(new Book("ada", "d", "1")));
		} catch(Exception e) { e.printStackTrace(); }
	}
}