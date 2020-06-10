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

		System.out.println("Welkom bij MASTERMIND.\nTyp \"h\" voor hulp en \"q\" om te stoppen.");
		System.out.println("Voer een code in van 4 karakters en druk op enter om te beginnen met spelen.\n");

		while (true) {
			System.out.println("===================================================");
			String input = scanner.nextLine();
			System.out.println(" ");

			// check of input is toegestaan
			if (!(input.contains("a") || input.contains("b") || input.contains("c") || input.contains("d")
					|| input.contains("e") || input.contains("f") || input.contains("h") || input.contains("q"))) {
				System.out.println("Voer een geldige waarde in!");
			}

			if (input.equals("h")) {
				controller.callHelp();
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
