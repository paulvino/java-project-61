package hexlet.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final String RULES = "Find the greatest common divisor of given numbers.";
    public static final int BORDER_1 = 1;
    public static final int BORDER_100 = 100;

    public static void greatestCommonDivisorGame() {
        String[][] gcdData = new String[Engine.NUMBER_OF_ROUNDS_IN_GAME][Engine.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: gcdData) {
            int firstNumber = Utils.getRandomNumber(BORDER_1, BORDER_100);
            int secondNumber = Utils.getRandomNumber(BORDER_1, BORDER_100);
            round[Engine.QUESTION_INDEX_IN_ARRAY] = firstNumber + " " + secondNumber;
            round[Engine.CORRECT_ANSWER_INDEX_IN_ARRAY] = Integer.toString(getCorrectAnswer(firstNumber, secondNumber));
        }
        Engine.run(RULES, gcdData);
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
