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
	    // Verificar que a on la volem moure, no és fora del array
	    if (filaDesti < 0 || filaDesti >= 8 || columnaDesti < 0 || columnaDesti >= 8) {
	        return false;
	    }

	    // Verificar si la casella de destinació és la mateixa que la d'origen
	    if (filaDesti == filaInicial && columnaDesti == columnaInicial) {
	        return false;
	    }

	    // Verificar que a on la volem moure, no és on ja està una fitxa nostra
	    if (taulell[filaDesti][columnaDesti] != null
	            && taulell[filaDesti][columnaDesti].getColor().equalsIgnoreCase(colorJugador)) {
	        return false;
	    }

	    // Moviment cap endavant
	    if (colorJugador.equalsIgnoreCase("blanc") && filaDesti == filaInicial + 1 && columnaDesti == columnaInicial) {
	        return true;
	    }

	    if (colorJugador.equalsIgnoreCase("negre") && filaDesti == filaInicial - 1 && columnaDesti == columnaInicial) {
	        return true;
	    }

	    // Captura en diagonal
	    if (Math.abs(columnaDesti - columnaInicial) == 1) {
	        // Verificar si la casella de destinació conté una fitxa enemiga
	        if (taulell[filaDesti][columnaDesti] != null &&
	            !taulell[filaDesti][columnaDesti].getColor().equalsIgnoreCase(colorJugador)) {
	            // Verificar si el moviment és cap endavant segons color
	            if (colorJugador.equalsIgnoreCase("blanc") && filaDesti == filaInicial + 1) {
	                return true;
	            }
	            if (colorJugador.equalsIgnoreCase("negre") && filaDesti == filaInicial - 1) {
	                return true;
	            }
	        }
	    }

	    return false;
	}



}
