public class Taulell {

	// ATRIBUTOS
	private Fitxa[][] taulell = new Fitxa[8][8];

	// CONSTRUCTOR
	public Taulell() {
		inicialitzarTaulell();
	}

	private void inicialitzarTaulell() {
		// INSTANCIEM LES FITXES
		// EQUIP BLANC
		// Ruhks
		Ruhk ruhk1B = new Ruhk("blanc");
		Ruhk ruhk2B = new Ruhk("blanc");

		// Faras
		Faras faras1B = new Faras("blanc");
		Faras faras2B = new Faras("blanc");

		// Elefants
		Elefant elefant1B = new Elefant("blanc");
		Elefant elefant2B = new Elefant("blanc");

		Xa xaB = new Xa("blanc");
		Ministre ministreB = new Ministre("blanc");

		// Baidaqs
		Baidaq baidaq1B = new Baidaq("blanc");
		Baidaq baidaq2B = new Baidaq("blanc");
		Baidaq baidaq3B = new Baidaq("blanc");
		Baidaq baidaq4B = new Baidaq("blanc");
		Baidaq baidaq5B = new Baidaq("blanc");
		Baidaq baidaq6B = new Baidaq("blanc");
		Baidaq baidaq7B = new Baidaq("blanc");
		Baidaq baidaq8B = new Baidaq("blanc");

		// EQUIP NEGRO
		// Ruhks
		Ruhk ruhk1N = new Ruhk("negre");
		Ruhk ruhk2N = new Ruhk("negre");

		// Faras
		Faras faras1N = new Faras("negre");
		Faras faras2N = new Faras("negre");

		// Elefants
		Elefant elefant1N = new Elefant("negre");
		Elefant elefant2N = new Elefant("negre");

		Xa xaN = new Xa("negre");
		Ministre ministreN = new Ministre("negre");

		// Baidaqs
		Baidaq baidaq1N = new Baidaq("negre");
		Baidaq baidaq2N = new Baidaq("negre");
		Baidaq baidaq3N = new Baidaq("negre");
		Baidaq baidaq4N = new Baidaq("negre");
		Baidaq baidaq5N = new Baidaq("negre");
		Baidaq baidaq6N = new Baidaq("negre");
		Baidaq baidaq7N = new Baidaq("negre");
		Baidaq baidaq8N = new Baidaq("negre");

		// POSICIONAMENT INCIAL BLANC
		taulell[6][0] = baidaq1B;
		taulell[6][1] = baidaq2B;
		taulell[6][2] = baidaq3B;
		taulell[6][3] = baidaq4B;
		taulell[6][4] = baidaq5B;
		taulell[6][5] = baidaq6B;
		taulell[6][6] = baidaq7B;
		taulell[6][7] = baidaq8B;

		taulell[7][0] = ruhk1B;
		taulell[7][7] = ruhk2B;
		taulell[7][1] = faras1B;
		taulell[7][6] = faras2B;
		taulell[7][2] = elefant1B;
		taulell[7][5] = elefant2B;
		taulell[7][3] = xaB;
		taulell[7][4] = ministreB;

		// POSICIONAMENT INICIAL NEGRE
		taulell[0][0] = ruhk1N;
		taulell[0][7] = ruhk2N;
		taulell[0][1] = faras1N;
		taulell[0][6] = faras2N;
		taulell[0][2] = elefant1N;
		taulell[0][5] = elefant2N;
		taulell[0][3] = xaN;
		taulell[0][4] = ministreN;

		taulell[1][0] = baidaq1N;
		taulell[1][1] = baidaq2N;
		taulell[1][2] = baidaq3N;
		taulell[1][3] = baidaq4N;
		taulell[1][4] = baidaq5N;
		taulell[1][5] = baidaq6N;
		taulell[1][6] = baidaq7N;
		taulell[1][7] = baidaq8N;

		// POSICIONAMENT DE LES CASELLES BUIDES
		taulell[2][0] = new CasellaBuida();
		taulell[2][1] = new CasellaBuida();
		taulell[2][2] = new CasellaBuida();
		taulell[2][3] = new CasellaBuida();
		taulell[2][4] = new CasellaBuida();
		taulell[2][5] = new CasellaBuida();
		taulell[2][6] = new CasellaBuida();
		taulell[2][7] = new CasellaBuida();

		taulell[3][0] = new CasellaBuida();
		taulell[3][1] = new CasellaBuida();
		taulell[3][2] = new CasellaBuida();
		taulell[3][3] = new CasellaBuida();
		taulell[3][4] = new CasellaBuida();
		taulell[3][5] = new CasellaBuida();
		taulell[3][6] = new CasellaBuida();
		taulell[3][7] = new CasellaBuida();

		taulell[4][0] = new CasellaBuida();
		taulell[4][1] = new CasellaBuida();
		taulell[4][2] = new CasellaBuida();
		taulell[4][3] = new CasellaBuida();
		taulell[4][4] = new CasellaBuida();
		taulell[4][5] = new CasellaBuida();
		taulell[4][6] = new CasellaBuida();
		taulell[4][7] = new CasellaBuida();

		taulell[5][0] = new CasellaBuida();
		taulell[5][1] = new CasellaBuida();
		taulell[5][2] = new CasellaBuida();
		taulell[5][3] = new CasellaBuida();
		taulell[5][4] = new CasellaBuida();
		taulell[5][5] = new CasellaBuida();
		taulell[5][6] = new CasellaBuida();
		taulell[5][7] = new CasellaBuida();
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    // Añadir fila superior con letras
	    sb.append("  a b c d e f g h\n");

	    // Iterar sobre el tablero
	    for (int i = 7; i >= 0; i--) {
	        // Añadir número de fila a la izquierda
	        sb.append(i + 1).append(" ");
	        for (int j = 0; j < 8; j++) {
	            // Añadir representación visual de la ficha en la posición i, j
	            if (taulell[i][j] != null) {
	                sb.append(taulell[i][j].getVisual()).append(" ");
	            } else {
	                sb.append("· ");
	            }
	        }
	        // Añadir salto de línea
	        sb.append("\n");
	    }

	    // Añadir fila inferior con letras
	    sb.append("  a b c d e f g h\n");

	    // Retornar el tablero como cadena de caracteres
	    return sb.toString();
	}
}


/*
Fitxa[][] taulell = { {'r', 'f', 'e', 'x', 'm', 'e', 'f', 'r', },
					 {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', },
					 {'·', '·', '·', '·', '·', '·', '·', '·', },
					 {'·', '·', '·', '·', '·', '·', '·', '·', },
					 {'·', '·', '·', '·', '·', '·', '·', '·', },
					 {'·', '·', '·', '·', '·', '·', '·', '·', },
					 {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', },
					 {'R', 'F', 'E', 'X', 'M', 'E', 'F', 'R', }};
*/
