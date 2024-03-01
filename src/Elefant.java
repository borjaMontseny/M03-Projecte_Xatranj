public class Elefant extends Fitxa {

	// CONSTRUCTOR
	public Elefant(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÈTODES
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'e';
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'E';
		} else {
			return '⚠';
		}
	}

	@Override
	public boolean validarMoviment(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti,
			String colorJugador, Fitxa[][] taulell) {

		if (filaDesti < 0 || filaDesti >= 8 || columnaDesti < 0 || columnaDesti >= 8) {
			return false;
		}

		// Comprovació si el moviment és diagonal i de dues posicions
		if (Math.abs(filaDesti - filaInicial) == 2 && Math.abs(columnaDesti - columnaInicial) == 2) {
			if (taulell[filaDesti][columnaDesti] == null
					|| !taulell[filaDesti][columnaDesti].getColor().equalsIgnoreCase(colorJugador)) {
				return true;
			}
		}

		return false;
	}

	public char getVisual() {
		return visual;
	}
}
