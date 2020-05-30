/**
 * Holds information about the face of a rubix cube
 * @author Ian McDowell 2020
 *
 */
public class Face {
	public int[] size;
	public Cell[][] cells;
	
	/**
	 * Constructor for new Faces with homogeneous Cell color
	 * @param size
	 * @param color
	 */
	public Face(int[] size, String color) {
		try {
			this.setSize(size);
			this.setCellsHomogeneous(color);
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * Constructor for new Faces with specific Cells
	 * @param size 2-element array containing number of rows and columns
	 * @param cells 2-dimensional matrix containing all cells in a face
	 */
	public Face(int[] size, Cell[][] cells) {
		try {
			this.setSize(size);
			this.setCells(cells);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Used to validate and set Face size
	 * @param size The size wished to be set
	 * @throws InvalidSizeException if size coordinates are less than 1
	 */
	private void setSize(int[] size) throws Exception{
		for(int val : size) {
			if(val < 1) {
				throw new Exception("All size coordinates must be >= 1");
			}
		}
		this.size = size;
	}
	
	/**
	 * Used to validate and set Face cells
	 * @param cells 2-dimensional cells matrix wished to be set
	 * @throws SizeMismatchException if cells matrix is not the same size as the Face's size
	 */
	private void setCells(Cell[][] cells) throws Exception{
		if(cells.length != this.size[0]) {
			throw new Exception("The cells matrix must be the same dimensions as the Face's size.");
		}
		for(int i = 0; i < cells.length; i++) {
			if(cells[i].length != this.size[1]) {
				throw new Exception("The cells matrix must be the same dimensions as the Face's size.");
			}
		}
		this.cells = cells;
	}
	
	/**
	 * Sets the Face's Cell matrix with homogeneous color
	 * @param color The color of all Cells in the Face
	 */
	private void setCellsHomogeneous(String color) {
		Cell[][] cells = new Cell[size[0]][size[1]];
		for(int i = 0; i < this.size[0]; i++) {
			for(int j = 0; j < this.size[1]; j++) {
				cells[i][j] = new Cell(color, new int[]{i,j});
			}
		}
		this.cells = cells;
	}
	
	/**
	 * Returns information about Face as string
	 */
	public String toString() {
		String sizeStr = "(";
		for(int i = 0; i < this.size.length; i++) {
			sizeStr += this.size[i];
			if(i != this.size.length - 1) {
				sizeStr += ", ";
			}
		}
		String cellStr = new String();
		for(int i = 0; i < this.cells.length; i++) {
			cellStr += "|";
			for(int j = 0; j < this.cells[i].length; j++) {
				cellStr += this.cells[i][j].color.charAt(0);
				if(j != this.cells[i].length-1) {
					cellStr += " ";
				}
			}
			cellStr += "|\n";
		}
		return "Size: " + sizeStr + ")\nCells:\n" + cellStr;
	}

}
