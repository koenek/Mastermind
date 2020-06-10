package mastermind;

import java.util.Arrays;
import java.util.Random;

public class Controller {
	private String[] letters = { "a", "b", "c", "d", "e", "f" };
	Random random = new Random(6);

	public String[] generateCode() {
		String[] code = { letters[randomNum()], letters[randomNum()],letters[randomNum()], letters[randomNum()] };
		return code;
	}

	public int randomNum() {
		return (int) Math.floor(Math.random() * 6);
	}

	public boolean checkCode(String[] computerCode, String playerInput) {
		String[] playerCode = playerInput.split("|"); // Maak van String playerInput een array om makkelijker te vergelijken met Array computerCode
	
		if (Arrays.toString(computerCode).equals(Arrays.toString(playerCode))) { // als codes op alle posities equal zijn, return true
			return true;
		} else {
			int pstnEqualCount = 0;
			int pstnNotEqualCount = 0;

			for (int i = 0; i < playerCode.length; i++) {
				if (Arrays.asList(playerCode).contains(computerCode[i])) { // als playercode de huidige letter van computerCode bevat
					if (playerCode[i].equals(computerCode[i])) { // check dan of hij op dezelfde positie staat, zo ja:
						pstnEqualCount++;
					} else { // zo niet:
						pstnNotEqualCount++;
					}
				}			
			}
			System.out.println(pstnEqualCount + " letters op de CORRECTE plaats");
			System.out.println(pstnNotEqualCount + " letters correct, maar NIET op de correcte plaats");
		}
		return false; // return altijd false als niet alle letters overeen komen
	}

	public void callHelp() {
		System.out.println(
				"De computer bedenkt een willekeurige 4-cijferige code bestaande uit de letters a, b, c, d, e, f. \n"
						+ "Aan jou de taak deze code te kraken. Voer per beurt een 4-cijferige code in(bijvoorbeeld \"cdfa\") \n"
						+ "Na elke beurt zal de computer je vertellen hoeveel letters correct zijn EN op de juiste plek staan. \n"
						+ "Daarnaast vertelt hij je ook hoeveel correcte letters er zijn die niet op de juiste plek staan");
	}

}
