package hexlet.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static final int BORDER_MIN_FOR_PRIME = 3;
    public static void primeGame() {
        String[][] primeData = new String[Utils.NUMBER_OF_ROUNDS_IN_GAME][Utils.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: primeData) {
            int question = getQuestion();
            String correctAnswer = getCorrectAnswer(question);
            round[Utils.QUESTION_INDEX_IN_ARRAY] = Integer.toString(question);
            round[Utils.CORRECT_ANSWER_INDEX_IN_ARRAY] = correctAnswer;
        }
        Engine.gamesEngine(RULES, primeData);
    }

    public static int getQuestion() {
        int question = (int) (BORDER_MIN_FOR_PRIME + Math.random() * Utils.BORDER_100);
        return question;
    }

    public static String getCorrectAnswer(int question) {
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
}
