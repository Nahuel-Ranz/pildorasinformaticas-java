package firstpart.files.dirandfile;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ListFolderContent {
	private static String bleeding = "    ";
	
	public static void main(String[] args) {
		String path = "D:\\elhac\\Computing\\Courses\\Píldoras Informáticas\\Java\\pildorasinformaticas";
		File file = new File(path);
		
		folderContent(file, 0);
	}
	
	private static void folderContent(File path, int level) {
		IO.println("%s\\%s".formatted(spaces(level), path.getName()));
		
		HashMap<String, File> directories = new HashMap<String, File>();
		ArrayList<String> items = new ArrayList<String>();
		
		Arrays.stream(path.list()).forEach( item -> {
			File current = new File(path.getAbsoluteFile(), item);
			
			if(current.isDirectory()) directories.put(item, current);
			else items.add(item);
		});
		
		directories.forEach( (_, v) -> folderContent(v, level+1));
		items.forEach( item -> IO.println("%s. %s".formatted(spaces(level+1), item)));
	}
	
	private static StringBuilder spaces(int level) {
		StringBuilder result = new StringBuilder("");
		
		for(int i=0; i<level; i++) result.append(bleeding);
		return result;
	}
}