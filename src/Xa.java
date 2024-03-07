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
		// Comprovacio de Fila i Columna dins del rang del array [0-7]
		if (filaDesti < 0 || filaDesti >= 8 || columnaDesti < 0 || columnaDesti >= 8) {
			return false;
		}

		// Calculem la diferència absoluta per comprovar els moviments
		int filaDif = Math.abs(filaDesti - filaInicial);
		int columnaDif = Math.abs(columnaDesti - columnaInicial);

		// Verificar ortogonal i diagonalment 1 casella de diferència respecte d'on estava
		if ((filaDif == 1 && columnaDif == 0) || (filaDif == 0 && columnaDif == 1)
				|| (filaDif == 1 && columnaDif == 1)) {
			return true; // Vàlid
		}

		return false; // Invàlid
	}

	public char getVisual() {
		return visual;
	}
}
