
public class Faras extends Fitxa {

	// CONSTRUCTOR
	public Faras(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÉTODOS
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'f';
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'F';
		} else {
			return '?';
		}
	}

	public char getVisual() {
		return visual;
	}
}
