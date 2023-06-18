package hexlet.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final int NUMBER_OF_STEP = 8;
    public static final int BORDER_FOR_START_15 = 15;
    public static final int NUMBER_FOR_LENGTH = 3;
    public static final int MIN_NUMBERS = 5;

    public static void progressionGame() {
        String userName = Cli.getUserName();
        System.out.println("What number is missing in the progression?");

        boolean flag = true;
        int roundNumber = Utils.START_ROUND_NUMBER;
        while (flag && roundNumber <= Utils.FINAL_ROUND) {
            flag = Progression.progressionEngine();
            roundNumber++;
        }

        if (!flag) {
            roundNumber += Utils.ROUND_NUMBER_FOR_MISTAKES;
        }

        Engine.gameEnding(roundNumber, userName);
    }

    public static boolean progressionEngine() {
        String correctAnswer = Progression.askQuestion();
        String userAnswerProgression = Engine.getAnswer();
        return Progression.checkAnswer(correctAnswer, userAnswerProgression);
    }

    public static String[] getProgression() {
        int step = (int) (1 + (Math.random() * Progression.NUMBER_OF_STEP));
        int start = (int) (1 + (Math.random() * Progression.BORDER_FOR_START_15));
        int length = (int) (start + Progression.MIN_NUMBERS + (Math.random() * Progression.NUMBER_FOR_LENGTH));
        String[] nums = new String[length];

        for (int i = 0; i < length; i++) {
            nums[i] = Integer.toString(step * (i + 1));
        }

        return nums;
    }

    public static String getProgressionWithHiddenNum() {
        String[] progression = Progression.getProgression();
        int elementForReplace = (int) (Math.random() * progression.length);
        String answer = progression[elementForReplace];
        progression[elementForReplace] = "..";

        for (String element: progression) {
            System.out.print(element + " ");
        }
        System.out.println();

        return answer;
    }

    public static String askQuestion() {
        System.out.print("Question: ");
        String answer = Progression.getProgressionWithHiddenNum();
        return answer;
    }

    public static boolean checkAnswer(String correctAnswer, String userAnswer) {
        if (userAnswer.equals(correctAnswer)) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, correctAnswer);
            return false;
        }
    }
}
