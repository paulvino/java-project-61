package hexlet.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final int BORDER_MIN_FOR_PRIME = 3;
    public static void primeGame() {
        String userName = Cli.getUserName();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        boolean flag = true;
        int roundNumber = Utils.START_ROUND_NUMBER;
        while (flag && roundNumber <= Utils.FINAL_ROUND) {
            flag = Prime.primeEngine();
            roundNumber++;
        }

        if (!flag) {
            roundNumber += Utils.ROUND_NUMBER_FOR_MISTAKES;
        }

        Engine.gameEnding(roundNumber, userName);
    }

    public static boolean primeEngine() {
        int questionPrime = Prime.askQuestion();
        String userAnswerPrime = Engine.getAnswer();
        return Prime.checkAnswer(questionPrime, userAnswerPrime);
    }

    public static int askQuestion() {
        int question = (int) (Prime.BORDER_MIN_FOR_PRIME + Math.random() * Utils.BORDER_100);
        System.out.println("Question: " + question);
        return question;
    }

    public static String correctAnswer(int question) {
        int counter = 0;
        for (int i = 1; i <= ((question / 2) + 1); i++) {
            if (question % i == 0) {
                counter++;
            }

            if (counter > 1) {
                return "no";
            }
        }
        return "yes";
    }

    public static boolean checkAnswer(int question, String userAnswer) {
        String correctAnswer = Prime.correctAnswer(question);

        if (correctAnswer.equals(userAnswer)) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, correctAnswer);
            return false;
        }
    }
}
