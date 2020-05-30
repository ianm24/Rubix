/**
 * Stores data and methods for colors
 * @author Ian McDowell
 *
 */
public class ColorData {
	public static final String[] VALID_COLORS = {"red", "blue", "orange", "green", "white", "black"};
	
	public static boolean isColorValid(String color) {
		for(String vColor : VALID_COLORS) {
			if(vColor.equalsIgnoreCase(color)) {
				return true;
			}
		}
		return false;
	}
}
