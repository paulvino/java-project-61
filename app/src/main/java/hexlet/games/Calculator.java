package hexlet.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calculator {
    public static final String RULES = "What is the result of the expression?";
    public static final int NUMBER_OF_OPERATIONS = 3;
    public static void calcGame() {
        String[][] calcData = new String[Utils.NUMBER_OF_ROUNDS_IN_GAME][Utils.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: calcData) {
            int operationCalc = getOperation();
            int firstOperand = (int) (Math.random() * Utils.BORDER_20);
            int secondOperand = (int) (Math.random() * Utils.BORDER_20);
            round[Utils.QUESTION_INDEX_IN_ARRAY] = getQuestion(operationCalc, firstOperand, secondOperand);
            round[Utils.CORRECT_ANSWER_INDEX_IN_ARRAY] = getCorrectAnswer(operationCalc, firstOperand, secondOperand);
        }
        Engine.gamesEngine(RULES, calcData);
    }

    public static int getOperation() {
        return (int) (Math.random() * NUMBER_OF_OPERATIONS);
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
