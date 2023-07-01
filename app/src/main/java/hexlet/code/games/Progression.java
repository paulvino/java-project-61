package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Progression {
    public static final String RULES = "What number is missing in the progression?";
    public static final int BORDER_1 = 1;
    public static final int BORDER_0 = 0;
    public static final int NUMBER_OF_STEP = 8;
    public static final int BORDER_FOR_START_15 = 15;
    public static final int NUMBER_FOR_LENGTH = 3;
    public static final int MIN_NUMBERS = 5;

    public static void startProgressionGame() {
        String[][] progData = new String[Engine.NUMBER_OF_ROUNDS_IN_GAME][Engine.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: progData) {
            int step = Utils.getRandomNumber(BORDER_1, NUMBER_OF_STEP);
            int start = Utils.getRandomNumber(BORDER_0, BORDER_FOR_START_15);
            int length = Utils.getRandomNumber((start + MIN_NUMBERS), NUMBER_FOR_LENGTH);
            int indexToHide = Utils.getRandomNumber(BORDER_0, length);
            String[] progression = getProgression(step, length);
            String progressionWithHiddenNum = getProgressionWithHiddenNum(progression, indexToHide);
            round[Engine.QUESTION_INDEX_IN_ARRAY] = progressionWithHiddenNum;
            round[Engine.CORRECT_ANSWER_INDEX_IN_ARRAY] = progression[indexToHide];
        }
        Engine.runGameProcess(RULES, progData);
    }

    public static String[] getProgression(int step, int length) {
        String[] numbers = new String[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.toString(step * (i + 1));
        }
        return numbers;
    }

    public static String getProgressionWithHiddenNum(String[] progression, int indexToHide) {
        String[] resultProgression = progression.clone();
        resultProgression[indexToHide] = "..";

        String progressionWithHiddenNum = "";
        for (String element: resultProgression) {
            progressionWithHiddenNum += element + " ";
        }
        return progressionWithHiddenNum;
    }
}
