
public class Baidaq extends Fitxa {

	// CONSTRUCTOR
	public Baidaq(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÉTODOS
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'b';
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'B';
		} else {
			return '⚠';
		}
	}

	public char getVisual() {
		return visual;
	}

}