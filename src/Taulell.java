public class Taulell {

	// ATRIBUTOS
	private Fitxa[][] taulell = new Fitxa[8][8];

	// CONSTRUCTOR
	public Taulell() {
		inicialitzarTaulell();
	}

	// MÉTODOS
	private void inicialitzarTaulell() {
		// INSTANCIEM LES FITXES
		// EQUIP BLANC
		Ruhk ruhk1B = new Ruhk("blanc");
		Ruhk ruhk2B = new Ruhk("blanc");

		Faras faras1B = new Faras("blanc");
		Faras faras2B = new Faras("blanc");

		Elefant elefant1B = new Elefant("blanc");
		Elefant elefant2B = new Elefant("blanc");

		Xa xaB = new Xa("blanc");
		Ministre ministreB = new Ministre("blanc");

		Baidaq baidaq1B = new Baidaq("blanc");
		Baidaq baidaq2B = new Baidaq("blanc");
		Baidaq baidaq3B = new Baidaq("blanc");
		Baidaq baidaq4B = new Baidaq("blanc");
		Baidaq baidaq5B = new Baidaq("blanc");
		Baidaq baidaq6B = new Baidaq("blanc");
		Baidaq baidaq7B = new Baidaq("blanc");
		Baidaq baidaq8B = new Baidaq("blanc");

		// EQUIP NEGRE
		Ruhk ruhk1N = new Ruhk("negre");
		Ruhk ruhk2N = new Ruhk("negre");

		Faras faras1N = new Faras("negre");
		Faras faras2N = new Faras("negre");

		Elefant elefant1N = new Elefant("negre");
		Elefant elefant2N = new Elefant("negre");

		Xa xaN = new Xa("negre");
		Ministre ministreN = new Ministre("negre");

		Baidaq baidaq1N = new Baidaq("negre");
		Baidaq baidaq2N = new Baidaq("negre");
		Baidaq baidaq3N = new Baidaq("negre");
		Baidaq baidaq4N = new Baidaq("negre");
		Baidaq baidaq5N = new Baidaq("negre");
		Baidaq baidaq6N = new Baidaq("negre");
		Baidaq baidaq7N = new Baidaq("negre");
		Baidaq baidaq8N = new Baidaq("negre");

		// POSICIONAMENT INICIAL NEGRE
		taulell[6][0] = baidaq1N;
		taulell[6][1] = baidaq2N;
		taulell[6][2] = baidaq3N;
		taulell[6][3] = baidaq4N;
		taulell[6][4] = baidaq5N;
		taulell[6][5] = baidaq6N;
		taulell[6][6] = baidaq7N;
		taulell[6][7] = baidaq8N;

		taulell[7][0] = ruhk1N;
		taulell[7][7] = ruhk2N;
		taulell[7][1] = faras1N;
		taulell[7][6] = faras2N;
		taulell[7][2] = elefant1N;
		taulell[7][5] = elefant2N;
		taulell[7][3] = xaN;
		taulell[7][4] = ministreN;

		// POSICIONAMENT INCIAL BLANC
		taulell[0][0] = ruhk1B;
		taulell[0][7] = ruhk2B;
		taulell[0][1] = faras1B;
		taulell[0][6] = faras2B;
		taulell[0][2] = elefant1B;
		taulell[0][5] = elefant2B;
		taulell[0][3] = xaB;
		taulell[0][4] = ministreB;

		taulell[1][0] = baidaq1B;
		taulell[1][1] = baidaq2B;
		taulell[1][2] = baidaq3B;
		taulell[1][3] = baidaq4B;
		taulell[1][4] = baidaq5B;
		taulell[1][5] = baidaq6B;
		taulell[1][6] = baidaq7B;
		taulell[1][7] = baidaq8B;

	}

	// COMPTADORS
	// D'aquesta manera cada cop que cridem als getsB/N, es recompta de nou
	private int contarFichasBlanques() {
		int contadorBlanques = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (taulell[i][j] != null && taulell[i][j].getColor().equalsIgnoreCase("blanc")) {
					contadorBlanques++;
				}
			}
		}
		return contadorBlanques;
	}

	private int contarFichasNegres() {
		int contadorNegres = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (taulell[i][j] != null && taulell[i][j].getColor().equalsIgnoreCase("negre")) {
					contadorNegres++;
				}
			}
		}
		return contadorNegres;
	}

	public int getTotalFichasBlanques() {
		return contarFichasBlanques();
	}

	public int getTotalFichasNegres() {
		return contarFichasNegres();
	}
	
	public boolean hiHaXaBlanc() {
	    for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            if (taulell[i][j] instanceof Xa && taulell[i][j].getColor().equalsIgnoreCase("blanc")) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	public boolean hiHaXaNegre() {
	    for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            if (taulell[i][j] instanceof Xa && taulell[i][j].getColor().equalsIgnoreCase("negre")) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	// VALIDACIÓ DE MOVIMENTS
	public boolean validarCasella(int fila, int columna, String colorJugador) {
		// Verificar si la casella está fora del rang
		if (fila < 0 || fila >= 8 || columna < 0 || columna >= 8) {
			System.out.println("Coordenades fora de rang");
			return false;
		}

		// Verificar si la casella està buida
		if (taulell[fila][columna] == null) {
			System.out.println("Casella buida");
			return false;
		}

		// Verificar si la fitxa en la casella, és del color del jugador
		if (!taulell[fila][columna].getColor().equalsIgnoreCase(colorJugador)) {
			System.out.println("La fitxa seleccionada no és del teu color");
			return false;
		}

		// La casella i la fitxa son vàlids
		return true;
	}

	public boolean validarCasellaDesti(int filaDesti, int columnaDesti, String colorJugador) {
		// Verificar rang
		if (filaDesti < 0 || filaDesti >= 8 || columnaDesti < 0 || columnaDesti >= 8) {
			System.out.println("Coordenades de destinació fora del rang.");
			return false;
		}

		// Verificar casella buida
		if (taulell[filaDesti][columnaDesti] == null) {
			// La casilla de destino está vacía, por lo tanto, es válida
			return true;
		}

		// Verificar que la casella no tingui una fitxa pròpia
		if (taulell[filaDesti][columnaDesti].getColor().equalsIgnoreCase(colorJugador)) {
			System.out.println("La casella de destinació conté una fitxa teva. Tria una altra casella.");
			return false;
		}

		// Si no pasa per cap if, vol dir que hi ha una fitxa enemiga, si s'hi pot
		// moure, igual que si fos null
		return true;
	}

	public void moureFitxa(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti) {
		// Guardem la fitxa que es mourà
		Fitxa fitxaAMoure = taulell[filaInicial][columnaInicial];

		// Movem la fitxa a la destinació
		taulell[filaDesti][columnaDesti] = fitxaAMoure;

		// Posem null a la casella d'origen
		taulell[filaInicial][columnaInicial] = null;
	}

	public Fitxa[][] getTaulell() {
		return taulell;
	}

	public Fitxa getFitxa(int fila, int columna) {
		return taulell[fila][columna];
	}

	/**
	 * Retorna un String del taulell (amb marcs inclosos)
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		// Comencem desde l'última fila
		for (int fil = 7; fil >= 0; fil--) {
			// Fila a fila anem creant el marc esquerra de nums
			sb.append(fil + 1).append("| ");
			for (int col = 0; col < 8; col++) {
				// Sumem la visual de la fitxa al stringBuilder
				if (taulell[fil][col] != null) {
					sb.append(taulell[fil][col].getVisual()).append(" ");
				} else {
					sb.append("· "); // Si es null posem ·
				}
			}
			// Afegim un salt de línia per simular una nova fila
			sb.append("\n");
		}

		// Marc inferior amb lletres
		sb.append("  ----------------\n   a b c d e f g h\n");

		return sb.toString();
	}
}