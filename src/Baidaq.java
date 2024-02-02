
public class Baidaq extends Fitxa implements Accionari {

	public Baidaq(String color) {
		if (color.equalsIgnoreCase("Negre")) {
			this.color = color;
			this.visual = 'b';
		} else if (color.equalsIgnoreCase("Blanc")) {
			this.color = color;
			this.visual = 'B';
		}
	}

	@Override
	public void moure() {
		// TODO Auto-generated method stub

	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub

	}

}
