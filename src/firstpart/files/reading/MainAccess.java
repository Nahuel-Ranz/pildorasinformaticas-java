package firstpart.files.reading;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainAccess {
	public static void main(String[] args) {
		new ReadFile().read();
	}
}

class ReadFile {
	private FileReader file;
	public void read() {
		try {
			Path path = Paths.get("src", "files", "first_file.txt");
			file = new FileReader(path.toFile());
			
			int c = 0;
			while(c != -1) {
				c = file.read();
				IO.print((char)c);
			}
		} catch(FileNotFoundException e) {
			IO.println("File not found: %s".formatted(e));
		} catch(IOException e) {
			IO.println("Wrong reading: %s".formatted(e));
		} finally {
			try {file.close();}
			catch(IOException e) {IO.println(e);}
		}
	}
}