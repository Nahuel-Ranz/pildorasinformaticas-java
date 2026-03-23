package firstpart.files.writing;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainAccess {
	public static void main(String[] args) {
		new WriteFile().write();
	}
}

class WriteFile {
	private FileWriter writing;
	
	public void write() {
		String phrase = "This phrase will be written to the external file";
		
		try {
			Path path = Paths.get("src", "files", "second_file.txt");
			writing = new FileWriter(path.toFile());
			for(int i = 0; i<phrase.length(); i++) writing.write(phrase.charAt(i));
		} catch (IOException e) {
			IO.println("There was a error: %s".formatted(e));
		} finally {
			try {writing.close();}
			catch(IOException e) { IO.println("Error: %s: ".formatted(e));}
		}
	}
}