package firstpart.files.readandwrite;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ReadingWriting {
	public static void main(String[] args) {
		try {
			Path path = Paths.get("src", "files", "torneito.jpg");
			FileInputStream reading = new FileInputStream(path.toFile());
			boolean end = false;
			int count = 0, input;
			int[] bytes = new int[31873];
			
			while(!end) {
				input = reading.read();
				IO.println("%d) %d".formatted(count, input));
				
				if(input != -1) bytes[count++] = input;
				else end = true;
			}
			
			IO.println("Last element: %d".formatted(bytes[bytes.length-1]));
			
			createFile(bytes);
			reading.close();
		} catch(IOException e) {
			IO.println("There was an error: %s".formatted(e));
		}
	}
	
	static void createFile(int[] data) {
		try {
			Path path = Paths.get("src", "files", "torneito(copy).jpg");
			FileOutputStream writing = new FileOutputStream(path.toFile());
			
			Arrays.stream(data).forEach( d -> {
				try {writing.write(d);}
				catch (IOException e) {}
			});
			
			writing.close();
		} catch(IOException e) {}
	}
}