public class Faras extends Fitxa {

	// CONSTRUCTOR
	public Faras(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÈTODES
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'f'; // Representació visual per a Faras negra
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'F'; // Representació visual per a Faras blanca
		} else {
			return '⚠'; // Caràcter d'error
		}
	}

	@Override
	public boolean validarMoviment(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti,
			String colorJugador, Fitxa[][] taulell) {
		// Calcula la diferència absoluta entre les files i les columnes
		int difFilas = Math.abs(filaDesti - filaInicial);
		int difColumnas = Math.abs(columnaDesti - columnaInicial);

		// dues posicions ortogonalment i una altra perpendicular a aquestes (els
		// quadrats del mig poden estar ocupats)
		if ((difFilas == 2 && difColumnas == 1) || (difFilas == 1 && difColumnas == 2)) {
			// Verifica si la casella de destí està buida o conté una peça de l'oponent
			if (taulell[filaDesti][columnaDesti] == null
					|| !taulell[filaDesti][columnaDesti].getColor().equalsIgnoreCase(colorJugador)) {
				return true; // El moviment és vàlid
			}
		}

		return false; // Moviment invàlid
	}

	public char getVisual() {
		return visual;
	}

}
