/**
 * Keeps information for each cell of the rubix cube
 * @author Ian McDowell 2020
 *
 */
public class Cell {
	public String color;
	public int[] location;
	
	/**
	 * Constructor for new Cells
	 * @param color The color of the cell
	 * @param location The location of the cell
	 */
	public Cell(String color, int[] location) {
		try {
			this.setColor(color);
			this.setLocation(location);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Used to validate and set Cell color
	 * @param color The color wished to be set
	 * @throws InvalidColorException if color is not validZ 
	 */
	private void setColor(String color) throws Exception{
		if (ColorData.isColorValid(color)) {
			this.color = color;
		} else {
			throw new Exception("Cell color must be one of the following: " + ColorData.VALID_COLORS);
		}
	}
		
	/**
	 * Used to validate and set Cell location
	 * @param location The location wished to be set
	 * @throws OutOfBoundsLocationException if a coordinate of location is negative
	 */
	private void setLocation(int[] location) throws Exception{
		for(int coord : location) {
			if(coord < 0) {
				throw new Exception("All coordinates must be >= 0");
			}
		}
		this.location = location;
	}
	
	/**
	 * Returns information about Cell as string
	 */
	public String toString() {
		String locStr = "(";
		for(int coord : this.location) {
			locStr += coord + ", ";
		}
		return "Color: " + this.color + "\nLocation: " + locStr + ")\n";
	}

}
