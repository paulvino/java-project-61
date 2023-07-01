package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static final int BORDER_3 = 3;
    public static final int BORDER_100 = 100;
    public static void startPrimeGame() {
        String[][] primeData = new String[Engine.NUMBER_OF_ROUNDS_IN_GAME][Engine.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: primeData) {
            int question = Utils.getRandomNumber(BORDER_3, BORDER_100);
            String correctAnswer = isPrime(question) ? "yes" : "no";
            round[Engine.QUESTION_INDEX_IN_ARRAY] = Integer.toString(question);
            round[Engine.CORRECT_ANSWER_INDEX_IN_ARRAY] = correctAnswer;
        }
        Engine.runGameProcess(RULES, primeData);
    }

    public static boolean isPrime(int question) {
        int counter = 0;
        for (int i = 1; i <= ((question / 2) + 1); i++) {
            if (question % i == 0) {
                counter++;
            }
            if (counter > 1) {
                return false;
            }
        }
        return true;
    }
}
