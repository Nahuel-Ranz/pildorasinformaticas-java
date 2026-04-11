package secondpart.collections.ordering;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Person implements Comparable<Person> {
	private static int count = 1;
	private final int id;
	private String name;
	private String lastName;
	private final String dni;
	private final GregorianCalendar birthdate;
	
	public Person(String name, String lastName, String dni, GregorianCalendar birthdate) {
		this.id = count++;
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.birthdate = birthdate;
	}
	
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	public String getLastName() { return this.lastName; }
	public String getDni() { return this.dni; }
	public GregorianCalendar getBirthdate() { return this.birthdate; }
	
	public void setName(String name) { this.name = name; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Person) return ((Person)o).getDni().equals(this.dni);
		return false;
	}
	
	@Override
	public int hashCode() { return Objects.hash(this.dni); }
	
	@Override
	public int compareTo(Person p) {
		return Integer.parseInt(this.dni) - Integer.parseInt(p.getDni());
	}
	
	@Override
	public String toString() {
		return "[Name: %s | Last name: %s | DNI: %s | BirthDate: %s]\n"
			.formatted(this.name, this.lastName, this.dni, this.birthdate.getTime());
	}
}