package hexlet.code;

import java.util.Scanner;
import hexlet.games.Even;
import hexlet.games.Calculator;
import hexlet.games.GCD;
import hexlet.games.Progression;
import hexlet.games.Prime;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calculator\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.next();
        System.out.println();

        switch (userChoice) {
            case "0" -> System.out.println("See you next time!");
            case "1" -> Cli.getUserName();
            case "2" -> Even.evenGame();
            case "3" -> Calculator.calcGame();
            case "4" -> GCD.greatestCommonDivisorGame();
            case "5" -> Progression.progressionGame();
            case "6" -> Prime.primeGame();
            default -> System.out.println("You entered wrong number.");
        }
    }
}
