package hexlet.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calculator {
    public static final String RULES = "What is the result of the expression?";
    public static final int[] OPERATIONS = {0, 1, 2};
    public static final int BORDER_0 = 0;
    public static final int BORDER_20 = 20;

    public static void calcGame() {
        String[][] calcData = new String[Engine.NUMBER_OF_ROUNDS_IN_GAME][Engine.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: calcData) {
            int operationCalc = Utils.getRandomNumber(BORDER_0, OPERATIONS.length);
            int firstOperand = Utils.getRandomNumber(BORDER_0, BORDER_20);
            int secondOperand = Utils.getRandomNumber(BORDER_0, BORDER_20);
            round[Engine.QUESTION_INDEX_IN_ARRAY] = getQuestion(operationCalc, firstOperand, secondOperand);
            round[Engine.CORRECT_ANSWER_INDEX_IN_ARRAY] = getCorrectAnswer(operationCalc, firstOperand, secondOperand);
        }
        Engine.run(RULES, calcData);
    }

    public static String getQuestion(int operation, int firstOperand, int secondOperand) {
        String question;
        if (operation == 0) {
            question = firstOperand + " * " + secondOperand;
        } else if (operation == 1) {
            question = firstOperand + " - " + secondOperand;
        } else {
            question = firstOperand + " + " + secondOperand;
        }
        return question;
    }

    public static String getCorrectAnswer(int operation, int firstOperand, int secondOperand) {
        String multiply = Long.toString((long) firstOperand * secondOperand);
        String subtraction = Integer.toString(firstOperand - secondOperand);
        String sum = Integer.toString(firstOperand + secondOperand);
        return switch (operation) {
            case 0 -> multiply;
            case 1 -> subtraction;
            default -> sum;
        };
    }
}
