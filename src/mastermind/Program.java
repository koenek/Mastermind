package mastermind;

import java.util.Scanner;

/**
 * @author kevin
 *
 */
public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller();
		UserInterface UI = new UserInterface(controller, scanner);
		
		UI.start();
		
	}

}
