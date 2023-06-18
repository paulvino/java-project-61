package hexlet.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static void greatestCommonDivisorGame() {
        String userName = Cli.getUserName();
        System.out.println("Find the greatest common divisor of given numbers.");

        boolean flag = true;
        int roundNumber = Utils.START_ROUND_NUMBER;
        while (flag && roundNumber <= Utils.FINAL_ROUND) {
            flag = GCD.greatestCommonDivisorEngine();
            roundNumber++;
        }

        if (!flag) {
            roundNumber += Utils.ROUND_NUMBER_FOR_MISTAKES;
        }

        Engine.gameEnding(roundNumber, userName);
    }

    public static boolean greatestCommonDivisorEngine() {
        int firstNumber = (int) (1 + (Math.random() * Utils.BORDER_100));
        int secondNumber = (int) (1 + (Math.random() * Utils.BORDER_100));
        GCD.askQuestion(firstNumber, secondNumber);
        int correctAnswerGCD = GCD.getCorrectAnswer(firstNumber, secondNumber);
        String userAnswerGCD = Engine.getAnswer();
        return GCD.checkAnswer(correctAnswerGCD, userAnswerGCD);
    }

    public static void askQuestion(int firstNumber, int secondNumber) {
        System.out.println("Question: " + firstNumber + " " + secondNumber);
    }

    public static int getCorrectAnswer(int firstNumber, int secondNumber) {
        int correctAnswer = Math.min(firstNumber, secondNumber);
        while (correctAnswer >= 1) {
            if (firstNumber % correctAnswer == 0 && secondNumber % correctAnswer == 0) {
                return correctAnswer;
            } else {
                correctAnswer--;
            }
        }
        return correctAnswer;
    }

    public static boolean checkAnswer(int correctAnswer, String userAnswer) {
        if (userAnswer.equals(Integer.toString(correctAnswer))) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, Integer.toString(correctAnswer));
            return false;
        }
    }
}
