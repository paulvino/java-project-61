package hexlet.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static void evenGame() {
        String[][] evenData = new String[Utils.NUMBER_OF_ROUNDS_IN_GAME][Utils.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: evenData) {
            String question = getQuestion();
            String correctAnswer = isEven(question);
            round[Utils.QUESTION_INDEX_IN_ARRAY] = question;
            round[Utils.CORRECT_ANSWER_INDEX_IN_ARRAY] = correctAnswer;
        }
        Engine.gamesEngine(RULES, evenData);
    }

    public static String getQuestion() {
        String question = Integer.toString((int) (Math.random() * Utils.BORDER_100));
        return question;
    }

    public static String isEven(String question) {
        int intQuestion = Integer.parseInt(question);
        return intQuestion % 2 == 0 ? "yes" : "no";
    }
}
