package firstpart.files.reading;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BR_Pistolero {
	public static void main(String[] args) {
		new BR().read();
	}
}

class BR {
	private FileReader fr;
	private BufferedReader br;
	
	public void read() {
		try {
			Path path = Paths.get("src", "files", "pistolero.txt");
			fr = new FileReader(path.toFile());
			br = new BufferedReader(fr);
			
			String line = "";
			while(line != null) {
				line = br.readLine();
				
				if(line != null) IO.println(line);
			}
		} catch(IOException e) {
			IO.println("There was an error: %s".formatted(e));
		}
	}
}