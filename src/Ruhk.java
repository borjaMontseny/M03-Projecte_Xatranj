public class Ruhk extends Fitxa {

	// CONSTRUCTOR
	public Ruhk(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÈTODES
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'r';
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'R';
		} else {
			return '⚠';
		}
	}

	@Override
	public boolean validarMoviment(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti,
			String colorJugador, Fitxa[][] taulell) {
		// Verifica si el moviment és vertical o horitzontal (com en una torre d'escacs)
		if (filaInicial != filaDesti && columnaInicial != columnaDesti) {
			return false; // No es mou vertical o horitzontalment
		}

		// Verifica si hi ha peces bloquejant el camí verticalment
		if (filaInicial != filaDesti) {
			int minFila = Math.min(filaInicial, filaDesti);
			int maxFila = Math.max(filaInicial, filaDesti);
			for (int fila = minFila + 1; fila < maxFila; fila++) {
				if (taulell[fila][columnaInicial] != null) {
					return false; // Hi ha una peça bloquejant el camí
				}
			}
		}

		// Verifica si hi ha peces bloquejant el camí horitzontalment
		if (columnaInicial != columnaDesti) {
			int minColumna = Math.min(columnaInicial, columnaDesti);
			int maxColumna = Math.max(columnaInicial, columnaDesti);
			for (int columna = minColumna + 1; columna < maxColumna; columna++) {
				if (taulell[filaInicial][columna] != null) {
					return false; // Hi ha una peça bloquejant el camí
				}
			}
		}

		// Verifica si la casella de destinació està buida o conté una fitxa de
		// l'oponent
		if (taulell[filaDesti][columnaDesti] != null
				&& taulell[filaDesti][columnaDesti].getColor().equalsIgnoreCase(colorJugador)) {
			return false; // La casella de destinació conté una peça del mateix color
		}

		return true;
	}

	public char getVisual() {
		return visual;
	}

}
