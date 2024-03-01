public abstract class Fitxa {

	// ATRIBUTOS
	protected String color;
	protected char visual;

	// CONSTRUCTOR
	public Fitxa() {
		super();
	}

	public Fitxa(String color, char visual) {
		this.color = color;
		this.visual = visual;
	}

	// MÉTODOS
	public abstract boolean validarMoviment(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti,
			String colorJugador, Fitxa[][] taulell);

	public String getColor() {
		return color;
	}

	public char getVisual() {
		return visual;
	}

}
