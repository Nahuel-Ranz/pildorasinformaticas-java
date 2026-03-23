package firstpart.files.serialization;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Start {
	public static void main(String[] args) {
		Person[] persons = new Person[3];
		
		persons[0] = new Person("Nahuel", "Ranz");
		persons[1] = new Person("Magalí", "Silva");
		persons[2] = new Person("Juan", "Sotelo");
		
	//	Arrays.stream(persons).forEach( p -> IO.println(p));
		try {
			Path path = Paths.get("src", "files", "3_Persons.javao");
			
			/*var writing = new ObjectOutputStream(new FileOutputStream(path.toFile()));
			writing.writeObject(persons);
			writing.close();
			*/
			var reading = new ObjectInputStream(new FileInputStream(path.toFile()));
			var recovery = (Person[])reading.readObject();
			reading.close();
			
			Arrays.stream(recovery).forEach( p -> IO.println("-> "+ p));
		} catch(ClassNotFoundException e) {
		} catch(IOException e) {}
	}
}