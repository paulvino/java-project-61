package hexlet.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final String RULES = "Find the greatest common divisor of given numbers.";
    public static void greatestCommonDivisorGame() {
        String[][] gcdData = new String[Utils.NUMBER_OF_ROUNDS_IN_GAME][Utils.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: gcdData) {
            int firstNumber = (int) (1 + (Math.random() * Utils.BORDER_100));
            int secondNumber = (int) (1 + (Math.random() * Utils.BORDER_100));
            round[Utils.QUESTION_INDEX_IN_ARRAY] = getQuestion(firstNumber, secondNumber);
            round[Utils.CORRECT_ANSWER_INDEX_IN_ARRAY] = Integer.toString(getCorrectAnswer(firstNumber, secondNumber));
        }
        Engine.gamesEngine(RULES, gcdData);
    }

    public static String getQuestion(int firstNumber, int secondNumber) {
        return firstNumber + " " + secondNumber;
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
}
