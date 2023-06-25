package hexlet.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Progression {
    public static final String RULES = "What number is missing in the progression?";
    public static final int NUMBER_OF_STEP = 8;
    public static final int BORDER_FOR_START_15 = 15;
    public static final int NUMBER_FOR_LENGTH = 3;
    public static final int MIN_NUMBERS = 5;

    public static void progressionGame() {
        String[][] progData = new String[Utils.NUMBER_OF_ROUNDS_IN_GAME][Utils.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: progData) {
            String[] progrArray = getProgressionWithHiddenNum();
            round[Utils.QUESTION_INDEX_IN_ARRAY] = progrArray[0];
            round[Utils.CORRECT_ANSWER_INDEX_IN_ARRAY] = progrArray[1];
        }
        Engine.gamesEngine(RULES, progData);
    }

    public static String[] getProgression() {
        int step = (int) (1 + (Math.random() * NUMBER_OF_STEP));
        int start = (int) (1 + (Math.random() * BORDER_FOR_START_15));
        int length = (int) (start + MIN_NUMBERS + (Math.random() * NUMBER_FOR_LENGTH));
        String[] nums = new String[length];

        for (int i = 0; i < length; i++) {
            nums[i] = Integer.toString(step * (i + 1));
        }
        return nums;
    }

    public static String[] getProgressionWithHiddenNum() {
        String[] progression = getProgression();
        int elementForReplace = (int) (Math.random() * progression.length);
        String answer = progression[elementForReplace];
        progression[elementForReplace] = "..";

        String progressionWithHiddenNum = "";
        for (String element: progression) {
            progressionWithHiddenNum += element + " ";
        }

        String[] finalProgression = {progressionWithHiddenNum, answer};
        return finalProgression;
    }
}
