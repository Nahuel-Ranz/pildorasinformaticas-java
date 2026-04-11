package secondpart.collections.ordering;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		TreeSet<Person> persons = new TreeSet<Person>(Comparator
			.comparing(Person::getName)
			.thenComparing(Person::getLastName)
			.thenComparing(Person::getDni)
		);
		
		persons.add(new Person("Nahue", "Ranz", "40608684", new GregorianCalendar(1996, 10, 04)));
		persons.add(new Person("Lucas", "Gómez", "31245678", new GregorianCalendar(1990, 3, 15)));
		persons.add(new Person("María", "Fernández", "28965432", new GregorianCalendar(1988, 7, 22)));
		persons.add(new Person("Sofía", "Martínez", "33456789", new GregorianCalendar(1995, 1, 9)));
		persons.add(new Person("Juan", "Pérez", "30111222", new GregorianCalendar(1989, 11, 30)));
		persons.add(new Person("Valentina", "López", "35678901", new GregorianCalendar(1998, 5, 18)));
		persons.add(new Person("Mateo", "Rodríguez", "29988776", new GregorianCalendar(1992, 9, 3)));
		persons.add(new Person("Camila", "Sánchez", "37890123", new GregorianCalendar(2000, 0, 25)));
		persons.add(new Person("Analía", "Gómez", "40190123", new GregorianCalendar(1994, 5, 14)));
		persons.add(new Person("Analía", "Ramírez", "28765432", new GregorianCalendar(1987, 6, 14)));
		persons.add(new Person("Lucía", "Torres", "34567890", new GregorianCalendar(1996, 2, 8)));
		persons.add(new Person("Agustín", "Flores", "32123456", new GregorianCalendar(1991, 10, 27)));
		persons.add(new Person("Martina", "Acosta", "36789012", new GregorianCalendar(1999, 4, 12)));
		persons.add(new Person("Joaquín", "Medina", "29876543", new GregorianCalendar(1986, 8, 5)));
		persons.add(new Person("Catalina", "Castro", "35432109", new GregorianCalendar(1997, 3, 19)));
		persons.add(new Person("Franco", "Ortiz", "30987654", new GregorianCalendar(1993, 7, 1)));
		persons.add(new Person("Julieta", "Silva", "38901234", new GregorianCalendar(2001, 6, 21)));
		persons.add(new Person("Benjamín", "Suárez", "27654321", new GregorianCalendar(1985, 2, 11)));
		persons.add(new Person("Renata", "Molina", "36543210", new GregorianCalendar(1998, 9, 29)));
		persons.add(new Person("Santiago", "Navarro", "31876543", new GregorianCalendar(1992, 1, 6)));
		persons.add(new Person("Emilia", "Cabrera", "37765432", new GregorianCalendar(2000, 11, 17)));
		persons.add(new Person("Ignacio", "Herrera", "30567891", new GregorianCalendar(1994, 5, 23)));
		
		IO.println(persons.toString());
	}
}