
public class Xatranj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] taulell = { {'r', 'f', 'e', 'x', 'm', 'e', 'f', 'r', },
							 {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', },
							 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
							 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
							 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
							 {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', },
							 {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', },
							 {'R', 'F', 'E', 'X', 'M', 'E', 'F', 'R', }};
		
		for (int fil = 0; fil < taulell.length; fil++) {
			for (int col = 0; col < taulell[fil].length; col++) {
				System.out.print(taulell[fil][col] + " ");
			}
			System.out.println();
		}

	}

}
