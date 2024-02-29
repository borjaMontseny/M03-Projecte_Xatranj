import java.util.Scanner;

public class Xatranj {

	public static void main(String[] args) {

		Taulell taulell = new Taulell();
		Scanner sc = new Scanner(System.in);

		do {
			tornBlanc(taulell, sc);
		} while (taulell.getTotalFichasBlanques() > 1 || taulell.getTotalFichasNegres() > 1);

		sc.close();
	}

	public static int demanarFila(Scanner sc) {
		System.out.print("Fila    -> ");
		return (sc.nextInt() - 1);
	}

	public static int demanarColumna(Scanner sc) {
		System.out.print("Columna -> ");
		char columnaChar = Character.toLowerCase(sc.next().charAt(0));
		switch (columnaChar) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		case 'h':
			return 7;
		default:
			return -1;
		}
	}

	public static void tornBlanc(Taulell taulell, Scanner sc) {
		int filaInicial;
		int columnaInicial;
		int filaDesti;
		int columnaDesti;
		String color = "blanc";

		System.out.println(taulell);
		System.out.println("Jugador -> Blanc");

		do {
			System.out.println("Origen");
			filaInicial = demanarFila(sc);
			columnaInicial = demanarColumna(sc);
			System.out.println("Fitxa   -> " + taulell.getFitxa(filaInicial, columnaInicial).getVisual());
		} while (!(taulell.validarCasella(filaInicial, columnaInicial, color)));

		do {
			System.out.println("Destí");
			filaDesti = demanarFila(sc);
			columnaDesti = demanarColumna(sc);
		} while (!(taulell.validarCasellaDesti(filaDesti, columnaDesti, color)));

	}

}
