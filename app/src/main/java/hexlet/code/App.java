package hexlet.code;

import java.util.Scanner;

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
            case "2" -> Engine.gameProcess("2");
            case "3" -> Engine.gameProcess("3");
            case "4" -> Engine.gameProcess("4");
            case "5" -> Engine.gameProcess("5");
            case "6" -> Engine.gameProcess("6");
            default -> System.out.println("You entered wrong number.");
        }
    }
}
