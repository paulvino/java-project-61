package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int BORDER_0 = 0;
    public static final int BORDER_100 = 100;

    public static void startEvenGame() {
        String[][] evenData = new String[Engine.NUMBER_OF_ROUNDS_IN_GAME][Engine.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: evenData) {
            int question = Utils.getRandomNumber(BORDER_0, BORDER_100);
            String correctAnswer = isEven(question) ? "yes" : "no";
            round[Engine.QUESTION_INDEX_IN_ARRAY] = Integer.toString(question);
            round[Engine.CORRECT_ANSWER_INDEX_IN_ARRAY] = correctAnswer;
        }
        Engine.runGameProcess(RULES, evenData);
    }

    public static boolean isEven(int question) {
        return question % 2 == 0;
    }
}
