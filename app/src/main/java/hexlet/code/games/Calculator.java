package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calculator {
    public static final String RULES = "What is the result of the expression?";
    public static final String[] OPERATORS = {" * ", " - ", " + "};
    public static final int BORDER_0 = 0;
    public static final int BORDER_20 = 20;

    public static void startCalculatorGame() {
        String[][] calcData = new String[Engine.NUMBER_OF_ROUNDS_IN_GAME][Engine.NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY];
        for (String[] round: calcData) {
            int firstOperand = Utils.getRandomNumber(BORDER_0, BORDER_20);
            int secondOperand = Utils.getRandomNumber(BORDER_0, BORDER_20);
            String operator = OPERATORS[Utils.getRandomNumber(BORDER_0, OPERATORS.length)];
            round[Engine.QUESTION_INDEX_IN_ARRAY] = firstOperand + operator + secondOperand;
            round[Engine.CORRECT_ANSWER_INDEX_IN_ARRAY] = getCorrectAnswer(operator, firstOperand, secondOperand);
        }
        Engine.runGameProcess(RULES, calcData);
    }

    public static String getCorrectAnswer(String operator, int firstOperand, int secondOperand) {
        return switch (operator) {
            case " * " -> Long.toString((long) firstOperand * secondOperand);
            case " - " -> Integer.toString(firstOperand - secondOperand);
            case " + " -> Integer.toString(firstOperand + secondOperand);
            default -> null;
        };
    }
}
