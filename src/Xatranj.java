import java.util.Scanner;

public class Xatranj {

    public static void main(String[] args) {
        Taulell taulell = new Taulell();
        Scanner sc = new Scanner(System.in);

        String color = "blanc";

        do {
            torn(taulell, sc, color);
            // La ternària s'encarrega de canviar el color
            color = (color.equals("blanc")) ? "negre" : "blanc";
        } while (taulell.getTotalFichasBlanques() > 1 && taulell.getTotalFichasNegres() > 1
                && taulell.hiHaXaBlanc() && taulell.hiHaXaNegre());

        anunciarGuanyador(taulell);

        sc.close();
    }

    public static int demanarFila(Scanner sc) {
        int fila;
        System.out.print("Fila    -> ");
        fila = sc.nextInt();
        while (fila < 1 || fila > 8) {
            System.out.println("Fila fora del rang [1 - 8]");
            System.out.print("Fila    -> ");
            fila = sc.nextInt();
        }
        return (fila - 1);
    }

    public static int demanarColumna(Scanner sc) {
        System.out.print("Columna -> ");
        char columnaChar = Character.toLowerCase(sc.next().charAt(0));
        char[] columnasValidas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
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


	public static void torn(Taulell taulell, Scanner sc, String color) {
		int filaInicial;
		int columnaInicial;
		int filaDesti;
		int columnaDesti;

		System.out.println(taulell);
		System.out.println("Jugador -> " + color.toUpperCase());

		do {
			System.out.println("Coordenades origen");
			filaInicial = demanarFila(sc);
			columnaInicial = demanarColumna(sc);
			if (taulell.getFitxa(filaInicial, columnaInicial) == null) {
				System.out.println("No hi ha cap fitxa en aquesta casella.");
			}
		} while (!taulell.validarCasella(filaInicial, columnaInicial, color));

		do {
			System.out.println("\nCoordenades destí");
			System.out.println("Tipus Fitxa -> '" + taulell.getFitxa(filaInicial, columnaInicial).getVisual() + "'");
			filaDesti = demanarFila(sc);
			columnaDesti = demanarColumna(sc);
		} while (!taulell.validarCasellaDesti(filaDesti, columnaDesti, color));

		switchMoviments(taulell, taulell.getFitxa(filaInicial, columnaInicial).getVisual(), filaInicial, columnaInicial,
				filaDesti, columnaDesti, color);
	}

	public static void switchMoviments(Taulell taulell, char visual, int filaInicial, int columnaInicial, int filaDesti,
			int columnaDesti, String color) {
		Fitxa fitxa = taulell.getFitxa(filaInicial, columnaInicial);
		if (fitxa != null) {
			switch (Character.toLowerCase(visual)) {
			case 'b':
				if (fitxa.validarMoviment(filaInicial, columnaInicial, filaDesti, columnaDesti, color,
						taulell.getTaulell())) {
					taulell.moureFitxa(filaInicial, columnaInicial, filaDesti, columnaDesti);
				}
				break;
			case 'r':
			case 'f':
			case 'e':
				if (fitxa.validarMoviment(filaInicial, columnaInicial, filaDesti, columnaDesti, color,
						taulell.getTaulell())) {
					taulell.moureFitxa(filaInicial, columnaInicial, filaDesti, columnaDesti);
				} else {
					System.out.println("Moviment no vàlid.");
				}
				break;
			default:
				System.out.println("Error de switchMoviments()");
			}
		} else {
			System.out.println("No hi ha cap fitxa en aquesta casella.");
		}
	}

	public static void anunciarGuanyador(Taulell taulell) {
		if (taulell.getTotalFichasBlanques() > taulell.getTotalFichasNegres()) {
			System.out.println("Guanya el jugador BLANC!");
		} else if (taulell.getTotalFichasBlanques() < taulell.getTotalFichasNegres()) {
			System.out.println("Guanya el jugador NEGRE!");
		}
	}

}
