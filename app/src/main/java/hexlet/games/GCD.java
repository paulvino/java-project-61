package hexlet.games;

import hexlet.code.Engine;

public class GCD {
    public static void askQuestion(int firstNumber, int secondNumber) {
        System.out.println("Question: " + firstNumber + ", " + secondNumber);
    }

    public static int getFirstNumber() {
        return (int) (Math.random() * 100);
    }

    public static int getSecondNumber() {
        return (int) (Math.random() * 100);
    }

    public static boolean checkAnswer(String userAnswer, int firstNumber, int secondNumber) {
        int correctAnswer = Math.min(firstNumber, secondNumber);
        while (correctAnswer >= 1) {
            if (firstNumber % correctAnswer == 0 && secondNumber % correctAnswer == 0) {
                break;
            } else {
                correctAnswer--;
            }
        }

        if (userAnswer.equals(Integer.toString(correctAnswer))) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, Integer.toString(correctAnswer));
            return false;
        }
    }
}
