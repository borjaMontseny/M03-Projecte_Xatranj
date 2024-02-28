
public class Ruhk extends Fitxa {

	// CONSTRUCTOR
	public Ruhk(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÉTODOS
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'r';
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'R';
		} else {
			return '?';
		}
	}

	public char getVisual() {
		return visual;
	}
	
}
