package graphics;
import java.awt.Font;
import java.util.Arrays;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;


public class Utils {
	static JMenuItem aux;
	static Object[] fonts = {"Arial", Font.PLAIN, 15};
	static int i = 0;

	public static String className(Object o) {
		return o.getClass().getSimpleName();
	}
	
	public static void println(String string) {
		System.out.println(string);
	}
	
	public static void println(int num) {
		System.out.println(num);
	}
	
	public static void println(char character) {
		System.out.println(character);
	}
	
	public static int centrate(int sideContainer, int sideFrame) {
		return sideContainer/2 - sideFrame/2;
	}
	
	public static void allFonts() {
		String []fonts = getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		Arrays.stream(fonts).forEach(font -> println(font));
	}
	
	public static String[] getFonts() {
		return getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	}
	
	public static String[] getMonths() {
		return new String[]{
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
		};
	}
	
	public static void addMenusToBar(JMenuBar bar, JMenu... menus) {
		Arrays.stream(menus).forEach( menu -> bar.add(menu));
	}
	
	public static void addItemsToMenu(JMenu menu, JMenuItem... items) {
		Arrays.stream(items).forEach( item -> menu.add(item));
	}
}