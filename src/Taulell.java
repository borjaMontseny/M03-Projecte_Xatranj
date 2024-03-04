public class Taulell {

	// ATRIBUTOS
	private static Taulell instance;
	private Fitxa[][] taulell = new Fitxa[8][8];

	// CONSTRUCTOR (private, hi accedim amb el mètode getInstance)
	private Taulell() {
		inicialitzarTaulell();
	}

	// MÈTODES
	/**
	 * Retorna una única instància del taulell (Singleton), creant-ne una nova si
	 * encara no existeix.
	 * 
	 * @return L'única instància del taulell.
	 */
	public static Taulell getInstance() {
		if (instance == null) {
			instance = new Taulell();
		}
		return instance;
	}

	/**
	 * Omple el taulell de fitxes, per a començar una partida
	 */
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

	/**
	 * Retorna la matriu de Fitxes[][]
	 * 
	 * @return taul
	 */
	public Fitxa[][] getTaulell() {
		return taulell;
	}

	public Fitxa getFitxa(int fila, int columna) {
		return taulell[fila][columna];
	}

	/**
	 * Retorna un String del taulell (amb marcs de guia de coordenades inclosos)
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