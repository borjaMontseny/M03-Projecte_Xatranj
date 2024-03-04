import java.util.InputMismatchException;
import java.util.Scanner;

public class Xatranj {

	public static void main(String[] args) {
		Taulell taulell = Taulell.getInstance();
		Scanner sc = new Scanner(System.in);

		String color = "blanc";

		do {
			torn(taulell, sc, color);
			// La ternària s'encarrega de canviar el color
			color = (color.equals("blanc")) ? "negre" : "blanc";
		} while (TaulellUtils.hiHaXaBlanc(taulell) && TaulellUtils.hiHaXaNegre(taulell));

		anunciarGuanyador(taulell);

		sc.close();
	}

	/**
	 * Sol·licita a l'usuari un nombre enter i gestiona les excepcions per entrada
	 * incorrecta.
	 * 
	 * @param sc L'objecte Scanner utilitzat per a l'entrada de l'usuari.
	 * @return El nombre enter seleccionat per l'usuari dins del rang [1 - 8].
	 */
	public static int demanarFila(Scanner sc) {
		int fila = 0;
		boolean entradaValida = false;

		do {
			try {
				System.out.print("Fila    -> ");
				fila = sc.nextInt();
				if (fila >= 1 && fila <= 8) {
					entradaValida = true;
				} else {
					System.out.println("Fila fora del rang [1 - 8]");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introdueix un enter entre [1 - 8].");
				sc.next();
			}
		} while (!entradaValida);

		return fila - 1;
	}

	/**
	 * Sol·licita a l'usuari una lletra de columna vàlida i retorna el seu índex.
	 * 
	 * @param sc L'objecte Scanner utilitzat per a l'entrada de l'usuari.
	 * @return L'índex de la columna seleccionada per l'usuari (0 - 7), o -1 si és
	 *         invàlida.
	 */
	public static int demanarColumna(Scanner sc) {
		System.out.print("Columna -> ");
		char columnaChar = Character.toLowerCase(sc.next().charAt(0));
		char[] columnasValidas = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		int columna = -1;
		for (int i = 0; i < columnasValidas.length; i++) {
			if (columnasValidas[i] == columnaChar) {
				columna = i;
				break;
			}
		}
		if (columna == -1) {
			System.out.println("Columna fora del rang [A - H]");
			return demanarColumna(sc);
		}
		return columna;
	}

	/**
	 * Realitza un torn del jugador actual, demanant per teclat les coordenades i
	 * validant els moviments
	 * 
	 * @param taulell El taulell actual del joc.
	 * @param sc      L'objecte Scanner utilitzat per a l'entrada de l'usuari.
	 * @param color   El color del jugador actual (Blanc o Negre).
	 */
	public static void torn(Taulell taulell, Scanner sc, String color) {
		int filaInicial;
		int columnaInicial;
		int filaDesti;
		int columnaDesti;

		System.out.println(taulell);
		System.out.println("Jugador -> " + color.toUpperCase());

		do {
			System.out.println("Coordenades ORIGEN");
			filaInicial = demanarFila(sc);
			columnaInicial = demanarColumna(sc);
			if (taulell.getFitxa(filaInicial, columnaInicial) == null) {
				System.out.println("No hi ha cap fitxa en aquesta casella.");
			}
			// taulell.validarCasella(filaInicial, columnaInicial, color)
		} while (!TaulellUtils.validarCasella(filaInicial, columnaInicial, color, taulell));

		do {
			System.out.println("\nCoordenades DESTÍ");
			System.out.println("Fitxa   -> '" + taulell.getFitxa(filaInicial, columnaInicial).getVisual() + "'");
			filaDesti = demanarFila(sc);
			columnaDesti = demanarColumna(sc);
		} while (!TaulellUtils.validarCasellaDesti(filaInicial, columnaInicial, color, taulell));

		switchMoviments(taulell, taulell.getFitxa(filaInicial, columnaInicial).getVisual(), filaInicial, columnaInicial,
				filaDesti, columnaDesti, color);
	}

	/**
	 * Realitza el moviment segons el tipus de fitxa seleccionada.
	 * 
	 * @param taulell        El taulell actual del joc.
	 * @param visual         Visual de la fitxa seleccionada.
	 * @param filaInicial    La fila de la casella d'origen.
	 * @param columnaInicial La columna de la casella d'origen.
	 * @param filaDesti      La fila de la casella de destí.
	 * @param columnaDesti   La columna de la casella de destí.
	 * @param color          El color del jugador actual (Blanc o Negre).
	 */
	public static void switchMoviments(Taulell taulell, char visual, int filaInicial, int columnaInicial, int filaDesti,
			int columnaDesti, String color) {
		Fitxa fitxa = taulell.getFitxa(filaInicial, columnaInicial);
		if (fitxa != null) {
			switch (Character.toLowerCase(visual)) {
			case 'b':
			case 'r':
			case 'f':
			case 'e':
				if (fitxa.validarMoviment(filaInicial, columnaInicial, filaDesti, columnaDesti, color,
						taulell.getTaulell())) {
					// moureFitxa(int filaInicial, int columnaInicial, int filaDesti, int
					// columnaDesti, Fitxa[][] taulell)
					TaulellUtils.moureFitxa(filaInicial, columnaInicial, filaDesti, columnaDesti, taulell);
					;
				} else {
					System.out.println("Moviment no vàlid.");
				}
				break;
			default:
				System.out.println("Error de switchMoviments()");
			}
		} else {
			System.out.println("No hi ha cap fitxa en aquesta casella");
		}
	}

	/**
	 * Anuncia el guanyador del joc basant-se en quin jugador té més fitxes al
	 * taulell i en la presència del Xa.
	 * 
	 * @param taulell El taulell actual del joc.
	 */
	public static void anunciarGuanyador(Taulell taulell) {
		boolean hiHaXaBlanc = TaulellUtils.hiHaXaBlanc(taulell);
		boolean hiHaXaNegre = TaulellUtils.hiHaXaNegre(taulell);

		// Comprovem si hi ha un Xa en el taulell
		if (hiHaXaBlanc && !hiHaXaNegre) {
			System.out.println("Guanya el jugador BLANC!");
		} else if (!hiHaXaBlanc && hiHaXaNegre) {
			System.out.println("Guanya el jugador NEGRE!");
		}
	}
}
