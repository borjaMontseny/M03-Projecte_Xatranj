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

	// MÉTODES
	/**
	 * Segons el tipus de fitxa, ens dirà si es pot moure
	 * 
	 * @param filaInicial
	 * @param columnaInicial
	 * @param filaDesti
	 * @param columnaDesti
	 * @param colorJugador
	 * @param taulell
	 * @return
	 */
	public abstract boolean validarMoviment(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti,
			String colorJugador, Fitxa[][] taulell);

	public String getColor() {
		return color;
	}

	public char getVisual() {
		return visual;
	}

}
