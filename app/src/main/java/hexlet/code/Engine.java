package hexlet.code;

import hexlet.games.Calculator;
import hexlet.games.Even;
import hexlet.games.GCD;
import hexlet.games.Progression;
import hexlet.games.Prime;

import java.util.Scanner;

public class Engine {

    public static void gameProcess(String gameChosen) {
        String userName = Engine.greeting();

        boolean flag = true;
        int roundNumber = 1;
        final int finalRoundNumber = 3;
        final int roundNumberForMistakes = 5;
        while (flag && roundNumber <= finalRoundNumber) {
            if (roundNumber == 1) {
                switch (gameChosen) {
                    case "2" -> System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                    case "3" -> System.out.println("What is the result of the expression?");
                    case "4" -> System.out.println("Find the greatest common divisor of given numbers.");
                    case "5" -> System.out.println("What number is missing in the progression?");
                    case "6" -> System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
                    default -> System.out.println("You entered wrong number.");
                }
            }
            switch (gameChosen) {
                case "2":
                    flag = Even.evenEngine();
                    break;
                case "3":
                    flag = Calculator.calculatorEngine();
                    break;
                case "4":
                    flag = GCD.greatestCommonDivisorEngine();
                    break;
                case "5":
                    flag = Progression.progressionEngine();
                    break;
                case "6":
                    flag = Prime.primeEngine();
                    break;
                default:
                    System.out.println("Something went wrong. :(");
            }
            if (!flag) {
                roundNumber += roundNumberForMistakes;
            }
            roundNumber++;
        }
        Engine.gameEnding(roundNumber, userName);
    }

    public static String greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void gameEnding(int roundNumber, String userName) {
        final int roundNumberWinner = 4;
        if (roundNumber == roundNumberWinner) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
        }
    }

    public static String getAnswer() {
        Scanner answer = new Scanner(System.in);
        System.out.print("Your answer: ");
        return answer.next();
    }

    public static void resultGood() {
        System.out.println("Correct!");
    }

    public static void resultBad(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer "
                + "was '" + correctAnswer + "'.");
    }
}
