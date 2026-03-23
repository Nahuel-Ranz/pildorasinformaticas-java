package firstpart.files.dirandfile;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HandlingFiles {
	public static void main(String[] args) {
		Path path = Paths.get("bin");
		File file = path.toFile();
		
		IO.println(file.getAbsolutePath());
		IO.println(file.exists());
	}
}