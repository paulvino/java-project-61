package hexlet.games;

import hexlet.code.Engine;

public class GCD {
    public static boolean greatestCommonDivisorEngine() {
        int firstNumber = (int) (1 + (Math.random() * 100));
        int secondNumber = (int) (1 + (Math.random() * 100));
        GCD.askQuestion(firstNumber, secondNumber);
        int correctAnswerGCD = GCD.getCorrectAnswer(firstNumber, secondNumber);
        String userAnswerGCD = Engine.getAnswer();
        return GCD.checkAnswer(userAnswerGCD, correctAnswerGCD);
    }

    public static void askQuestion(int firstNumber, int secondNumber) {
        System.out.println("Question: " + firstNumber + ", " + secondNumber);
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

    public static boolean checkAnswer(String userAnswer, int correctAnswer) {

        if (userAnswer.equals(Integer.toString(correctAnswer))) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, Integer.toString(correctAnswer));
            return false;
        }
    }
}
