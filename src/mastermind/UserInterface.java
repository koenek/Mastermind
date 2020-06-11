package mastermind;

import java.util.Scanner;

public class UserInterface {
	private Controller controller;
	private Scanner scanner;

	public UserInterface(Controller controller, Scanner scanner) {
		this.controller = controller;
		this.scanner = scanner;
	}

	public void start() {
		String[] computerCode = controller.generateCode();

		System.out.println("Welkom bij MASTERMIND.");
		System.out.println(
				"De computer bedenkt een willekeurige 4-cijferige code bestaande uit de letters a, b, c, d, e, f. \n"
						+ "Aan jou de taak deze code te kraken. Voer per beurt een 4-cijferige code in(bijvoorbeeld \"cdfa\") \n"
						+ "Na elke beurt zal de computer je vertellen hoeveel letters correct zijn EN op de juiste plek staan. \n"
						+ "Daarnaast vertelt hij je ook hoeveel correcte letters er zijn die niet op de juiste plek staan");

		while (true) {
			System.out.println("===================================================");
			String input = scanner.nextLine();
			System.out.println(" ");

			// check of input is toegestaan
			if (!(input.contains("a") || input.contains("b") || input.contains("c") || input.contains("d")
					|| input.contains("e") || input.contains("f") || input.contains("q"))) {
				System.out.println("Voer een geldige waarde in!");
			} else if (input.equals("q")) {
				System.out.println("Spel gestopt");
				break;
			} else if (input.length() < 4 || input.length() > 4) { // extra check voor incorrecte input
				System.out.println("Voer 4 letters in om een code te vormen");
			} else if (controller.checkCode(computerCode, input)) {
				System.out.println("Code gekraakt!");
				break;
			}
			System.out.println(" ");
		}
	}

}