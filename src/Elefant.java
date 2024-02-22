
public class Elefant extends Fitxa {
	
	// CONSTRUCTOR
	public Elefant(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÉTODOS
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'e';
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
