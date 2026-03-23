package firstpart.files.serialization;

public class Person implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String lastName;
	private int age;
	
	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}
	
	public String getLastName() {return this.lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	@Override
	public String toString() {
		return "[Name: %s - Last Name: %s - Age: %d]".formatted(this.name, this.lastName, this.age);
	}
}
