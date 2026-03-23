package firstpart.exceptions;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Exception1 {
	public static void main(String[] args) {
		
		/*
		 * Checked exceptions: these are situations where Java has already anticipated that exception may occur,
		 * so we are forced to enclose these situations (or codes) within a try-catch block.
		 * */
		try {
			var image = ImageIO.read(new File("resorces/images/copy.png"));
			System.out.println(image);
		}catch(IOException e) {
			System.out.println("Catched");
			e.printStackTrace();
		}
		
		/*
		 * Unchecked exceptions: these are situations that Java hasn't anticipated. Here, you, as the
		 * programmer, must to know what you're doing.
		 * */
		String[] string = new String[3];
		try {
			System.out.println(string[3]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Foreign index");
			e.printStackTrace();
		}
		System.out.println("Good Bye");
	}
}