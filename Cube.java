/**
 * Holds information on the rubix cube itself
 * @author Ian McDowell
 *
 */
public class Cube {
	private Face[] faces; //0:Top; 1:Bottom; 2:North; 3:East; 4:South; 5:West
	private static final String[] FACE_ORDER = {"Top", "Bottom", "North", "East", "South", "West"};
	
	public Cube() {
		Face[] faces = new Face[6];
		for(int i = 0; i < 6; i++) {
			faces[i] = new Face(new int[]{2,2}, ColorData.VALID_COLORS[i]);
		}
		this.faces = faces;
	}
	
	public Cube(int[] size) {
		Face[] faces = new Face[6];
		for(int i = 0; i < 6; i++) {
			faces[i] = new Face(new int[]{size[0],size[1]}, ColorData.VALID_COLORS[i]);
		}
		this.faces = faces;
	}
	
	public Cube(Face[] faces) {
		try {
			this.setFace(faces);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void setFace(Face[] faces) throws Exception{
		if(faces.length == 6) {
			this.faces = faces;
		} else {
			throw new Exception("Faces array must be of length 6.");
		}
	}
	
	public String toString() {
		String retStr = new String();
		for(int i = 0; i < this.faces.length; i++) {
			retStr += FACE_ORDER[i] + " Face:\n" + this.faces[i].toString() + "\n";
		}
		return retStr;
	}
}
