
public abstract class Fitxa {

	// ATRIBUTOS
	protected String color;
	protected char visual;

	// CONSTRUCTORES
	public Fitxa() {
		this.color = "neutral";
		this.visual = ' ';
	}

	// MÉTODOS
	public String getColor() {
		return color;
	}
	
	public char getVisual() {
		return visual;
	}

	@Override
	public String toString() {
		return String.valueOf(visual);
	}
}