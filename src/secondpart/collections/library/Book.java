package secondpart.collections.library;
import java.util.Objects;

public class Book implements Comparable<Book> {
	
	private String name;
	private String author;
	private final String ISBN;
	
	public Book(String name, String author, String ISBN) throws Exception {
		if(!ISBN.matches("^[0-9]+$")) throw new Exception("This isn't a valid ISBN.");
		this.author = author;
		this.name = name;
		this.ISBN = ISBN;
	}
	
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	public String getAuthor() { return this.author; }
	public void setAuthor(String author) { this.author = author; }
	
	public String getISBN() { return this.ISBN; }
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Book) return ((Book)o).ISBN.equals(this.ISBN);
		return false;
	}
	
	@Override
	public int hashCode() { return Objects.hash(this.ISBN); }
	
	@Override
	public int compareTo(Book book) {
		return Integer.parseInt(this.ISBN) - Integer.parseInt(book.getISBN());
	}
}