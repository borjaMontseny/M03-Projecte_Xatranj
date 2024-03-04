public abstract class TaulellUtils {
	/*
	 * Classe TaulellUtils per a simplificar la classe Taulell
	 */

	// COMPTADORS
	// D'aquesta manera cada cop que cridem als getsB/N, es recompta de nou
	public static int contarFichasBlanques(Taulell taulell) {
		int contadorBlanques = 0;
		Fitxa[][] fitxes = taulell.getTaulell();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (fitxes[i][j] != null && fitxes[i][j].getColor().equalsIgnoreCase("blanc")) {
					contadorBlanques++;
				}
			}
		}
		return contadorBlanques;
	}

	public static int contarFichasNegres(Taulell taulell) {
		int contadorNegres = 0;
		Fitxa[][] fitxes = taulell.getTaulell();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (fitxes[i][j] != null && fitxes[i][j].getColor().equalsIgnoreCase("negre")) {
					contadorNegres++;
				}
			}
		}
		return contadorNegres;
	}

	public static int getTotalFitxesBlanques(Taulell taulell) {
		return contarFichasBlanques(taulell);
	}

	public static int getTotalFitxesNegres(Taulell taulell) {
		return contarFichasNegres(taulell);
	}

	public static boolean hiHaXaBlanc(Taulell taulell) {
		Fitxa[][] fitxes = taulell.getTaulell();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((fitxes[i][j] instanceof Xa) && (fitxes[i][j].getColor().equalsIgnoreCase("blanc"))) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hiHaXaNegre(Taulell taulell) {
		Fitxa[][] fitxes = taulell.getTaulell();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((fitxes[i][j] instanceof Xa) && (fitxes[i][j].getColor().equalsIgnoreCase("negre"))) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean validarCasella(int fila, int columna, String colorJugador, Taulell taulell) {
		// Coordenades fora del rang
		if (fila < 0 || fila >= 8 || columna < 0 || columna >= 8) {
			System.out.println("Coordenades fora de rang");
			return false;
		}

		// Verificar si la casella està buida
		if (taulell.getFitxa(fila, columna) == null) {
			System.out.println("Casella buida");
			return false;
		}

		// Verificar si la ficha en la casella es del mateix color que el jugador
		if (!taulell.getFitxa(fila, columna).getColor().equalsIgnoreCase(colorJugador)) {
			System.out.println("La fitxa seleccionada no és del teu color");
			return false;
		}

		// La casella i la fitxa son vàlids
		return true;
	}

	public static boolean validarCasellaDesti(int filaDesti, int columnaDesti, String colorJugador, Taulell taulell) {
		// Verificar rango
		if (filaDesti < 0 || filaDesti >= 8 || columnaDesti < 0 || columnaDesti >= 8) {
			System.out.println("Coordenades de destinació fora del rang.");
			return false;
		}

		// Verificar casilla vacía
		if (taulell.getFitxa(filaDesti, columnaDesti) == null) {
			// La casilla de destino está vacía, por lo tanto, es válida
			return true;
		}

		// Verificar que la casilla no tenga una ficha propia
		if (taulell.getFitxa(filaDesti, columnaDesti).getColor().equalsIgnoreCase(colorJugador)) {
			System.out.println("La casella de destinació conté una fitxa teva. Tria una altra casella.");
			return false;
		}

		/*
		 * Si no pasa por ningún if, significa que hi ha una ficha enemiga, i ens hi
		 * podem moure allí
		 */
		return true;
	}

	public static void moureFitxa(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti,
			Taulell taulell) {
		Fitxa[][] fitxes = taulell.getTaulell();

		// Guardem la fitxa seleccionada
		Fitxa fitxaAMoure = fitxes[filaInicial][columnaInicial];

		// La movem al destí
		fitxes[filaDesti][columnaDesti] = fitxaAMoure;

		// A la seva posició inicial li posem null (deixem la casella buida)
		fitxes[filaInicial][columnaInicial] = null;
	}

}
