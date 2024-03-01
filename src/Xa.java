public class Xa extends Fitxa {

	// CONSTRUCTOR
	public Xa(String color) {
		this.color = color;
		this.visual = asignarVisual();
	}

	// MÉTODOS
	private char asignarVisual() {
		if (color.equalsIgnoreCase("negre")) {
			return 'x'; // Representació visual per a Xa negra
		} else if (color.equalsIgnoreCase("blanc")) {
			return 'X'; // Representació visual per a Xa blanca
		} else {
			return '⚠'; // Caràcter d'avís en cas de color no vàlid
		}
	}

	@Override
	public boolean validarMoviment(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti,
			String colorJugador, Fitxa[][] taulell) {
		// Comprovació dels límits del tauler
		if (filaDesti < 0 || filaDesti >= 8 || columnaDesti < 0 || columnaDesti >= 8) {
			return false;
		}

		// Comprovació del moviment similar al rei en escacs (màxim un moviment en
		// qualsevol direcció)
		if (Math.abs(filaDesti - filaInicial) <= 1 && Math.abs(columnaDesti - columnaInicial) <= 1) {
			return true; // Moviment vàlid
		}

		return false; // Moviment invàlid
	}

	public char getVisual() {
		return visual;
	}
}
