
public class Xa extends Fitxa {

	// CONSTRUCTOR
	public Xa(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÉTODOS
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'x';
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'X';
		} else {
			return '?';
		}
	}

	public char getVisual() {
		return visual;
	}

}
