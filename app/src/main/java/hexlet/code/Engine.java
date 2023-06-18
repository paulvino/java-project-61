package hexlet.code;

import java.util.Scanner;

public class Engine {

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
