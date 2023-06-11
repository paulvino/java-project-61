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

    public static int getFirstOperand() {
        return (int) (Math.random() * 20);
    }

    public static int getSecondOperand() {
        return (int) (Math.random() * 20);
    }

    public static boolean checkAnswer(int operation, String userAnswer, int firstOperand, int secondOperand) {
        switch (operation) {
            case 0:
                if (userAnswer.equals(Long.toString((long) firstOperand * secondOperand))) {
                    Engine.resultGood();
                    return true;
                } else {
                    System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer "
                            + "was '" + (firstOperand * secondOperand) + "'.");
                    return false;
                }
            case 1:
                if (userAnswer.equals(Integer.toString(firstOperand - secondOperand))) {
                    Engine.resultGood();
                    return true;
                } else {
                    System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer "
                            + "was '" + (firstOperand - secondOperand) + "'.");
                    return false;
                }
            case 2:
                if (userAnswer.equals(Integer.toString(firstOperand + secondOperand))) {
                    Engine.resultGood();
                    return true;
                } else {
                    System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer "
                            + "was '" + (firstOperand + secondOperand) + "'.");
                    return false;
                }
            default:
                return false;
        }
    }
}
