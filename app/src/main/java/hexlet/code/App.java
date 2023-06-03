package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.next();

        if (userChoice.equals("1")) {
            System.out.println("Welcome to the Brain Games!");
            Cli.getUserName();
        } else if (userChoice.equals("0")) {
            System.out.println("See you next time!");
        } else {
            System.out.println("You entered wrong number.");
        }
    }
}
