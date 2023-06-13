package hexlet.games;

import hexlet.code.Engine;

public class Calculator {
    public static int getOperation() {
        return (int) (Math.random() * 3);
    }

    public static void askQuestion(int operation, int firstOperand, int secondOperand) {
        if (operation == 0) {
            System.out.println("Question: " + firstOperand + "*" + secondOperand);
        } else if (operation == 1) {
            System.out.println("Question: " + firstOperand + "-" + secondOperand);
        } else if (operation == 2) {
            System.out.println("Question: " + firstOperand + "+" + secondOperand);
        }
    }

    public static boolean checkAnswer(int operation, String userAnswer, int firstOperand, int secondOperand) {

        long multiply = (long) firstOperand * secondOperand;
        int subtraction = firstOperand - secondOperand;
        int sum = firstOperand + secondOperand;
        switch (operation) {
            case 0:
                if (userAnswer.equals(Long.toString(multiply))) {
                    Engine.resultGood();
                    return true;
                } else {
                    Engine.resultBad(userAnswer, Long.toString(multiply));
                    return false;
                }
            case 1:
                if (userAnswer.equals(Integer.toString(firstOperand - secondOperand))) {
                    Engine.resultGood();
                    return true;
                } else {
                    Engine.resultBad(userAnswer, Integer.toString(subtraction));
                    return false;
                }
            case 2:
                if (userAnswer.equals(Integer.toString(sum))) {
                    Engine.resultGood();
                    return true;
                } else {
                    Engine.resultBad(userAnswer, Integer.toString(sum));
                    return false;
                }
            default:
                return false;
        }
    }
}
