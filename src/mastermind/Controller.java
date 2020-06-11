package mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Controller {
	private String[] letters = { "a", "b", "c", "d", "e", "f" };
	Random random = new Random(6);

	public String[] generateCode() {
		String[] code = { letters[randomNum()], letters[randomNum()], letters[randomNum()], letters[randomNum()] };
		return code;
	}

	public int randomNum() {
		return (int) Math.floor(Math.random() * 6);
	}

	public boolean checkCode(String[] computerCode, String playerInput) {
		String[] playerCode = playerInput.split("|"); // Maak van String playerInput een array

		// zet beide arrays om naar arraylist ivm flexibiliteit
		ArrayList<String> pc = new ArrayList<>();
		ArrayList<String> cc = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			pc.add(playerCode[i]);
			cc.add(computerCode[i]);
		}

		if (cc.equals(pc)) { // als codes op alle posities equal zijn, return true
			return true;
		} else {
			int pstnEqualCount = 0;
			int pstnNotEqualCount = 0;

			for (int i = 0; i < pc.size(); i++) {
				if (pc.get(i).equals(cc.get(i))) { // check dan of hij op dezelfde positie staat, zo ja:
					pstnEqualCount++;
					pc.set(i, "x"); // set x om dubbel tellen te voorkomen
					cc.set(i, "x");
				} else if (pc.contains(cc.get(i))) {
					pstnNotEqualCount++;
					String curVal = cc.get(i);
					System.out.println("curVal: " + curVal);
					pc.set(pc.indexOf(curVal), "x");
					cc.set(cc.indexOf(curVal), "x");
				}

			}

			System.out.println(pstnEqualCount + " letters op de CORRECTE plaats");
			System.out.println(pstnNotEqualCount + " letters correct, maar NIET op de correcte plaats");
		}
		return false; // return altijd false als niet alle letters overeen komen
	}
}