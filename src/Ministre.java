
public class Ministre extends Fitxa {

	// CONSTRUCTOR
	public Ministre(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÉTODOS
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'm';
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'M';
		} else {
			return '?';
		}
	}

	public char getVisual() {
		return visual;
	}
}
