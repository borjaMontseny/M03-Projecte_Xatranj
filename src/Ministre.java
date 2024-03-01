public class Ministre extends Fitxa {

	// CONSTRUCTOR
	public Ministre(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÉTODOS
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'm'; // Representación visual para Ministre negro
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'M'; // Representación visual para Ministre blanco
		} else {
			return '⚠'; // Carácter de advertencia en caso de color no válido
		}
	}

	@Override
	public boolean validarMoviment(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti,
			String colorJugador, Fitxa[][] taulell) {

		if (filaDesti < 0 || filaDesti >= 8 || columnaDesti < 0 || columnaDesti >= 8) {
			return false;
		}

		// Càlul per veure 1 casella en diagonal
		if (Math.abs(filaDesti - filaInicial) == 1 && Math.abs(columnaDesti - columnaInicial) == 1) {
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
