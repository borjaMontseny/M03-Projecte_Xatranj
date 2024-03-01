public class Baidaq extends Fitxa {

	// CONSTRUCTOR
	public Baidaq(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÉTODOS
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'b';
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'B';
		} else {
			return '⚠';
		}
	}

	@Override
	public boolean validarMoviment(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti,
			String colorJugador, Fitxa[][] taulell) {
		// Verificar si la casilla de destino está dentro del tablero
		if (filaDesti < 0 || filaDesti >= 8 || columnaDesti < 0 || columnaDesti >= 8) {
			return false;
		}

		// Verificar si la casilla de destino es la misma que la de origen
		if (filaDesti == filaInicial && columnaDesti == columnaInicial) {
			return false;
		}

		// Verificar si la casilla de destino contiene una pieza del mismo color
		if (taulell[filaDesti][columnaDesti] != null
				&& taulell[filaDesti][columnaDesti].getColor().equalsIgnoreCase(colorJugador)) {
			return false;
		}

		// Movimiento hacia adelante
		if (colorJugador.equalsIgnoreCase("blanc") && filaDesti == filaInicial + 1 && columnaDesti == columnaInicial) {
			return true;
		}

		if (colorJugador.equalsIgnoreCase("negre") && filaDesti == filaInicial - 1 && columnaDesti == columnaInicial) {
			return true;
		}

		// Captura en diagonal
		if (Math.abs(columnaDesti - columnaInicial) == 1) {
			if (colorJugador.equalsIgnoreCase("blanc") && filaDesti == filaInicial + 1) {
				return true;
			}

			if (colorJugador.equalsIgnoreCase("negre") && filaDesti == filaInicial - 1) {
				return true;
			}
		}

		return false;
	}

}
