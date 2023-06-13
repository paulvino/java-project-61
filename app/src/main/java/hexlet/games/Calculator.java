package hexlet.games;

import hexlet.code.Engine;

public class Calculator {
    public static boolean calculatorEngine() {
        int operationCalc = Calculator.getOperation();
        int firstOperand = (int) (Math.random() * 20);
        int secondOperand = (int) (Math.random() * 20);
        Calculator.askQuestion(operationCalc, firstOperand, secondOperand);
        long correctAnswerCalc = Calculator.getCorrectAnswer(operationCalc, firstOperand, secondOperand);
        String userAnswerCalc = Engine.getAnswer();
        return Calculator.checkAnswer(correctAnswerCalc, userAnswerCalc);
    }

    public static int getOperation() {
        return (int) (Math.random() * 3);
    }

    public static void askQuestion(int operation, int firstOperand, int secondOperand) {
        if (operation == 0) {
            System.out.println("Question: " + firstOperand + " * " + secondOperand);
        } else if (operation == 1) {
            System.out.println("Question: " + firstOperand + " - " + secondOperand);
        } else if (operation == 2) {
            System.out.println("Question: " + firstOperand + " + " + secondOperand);
        }
    }

    public static long getCorrectAnswer(int operation, int firstOperand, int secondOperand) {
        long multiply = (long) firstOperand * secondOperand;
        long subtraction = (long) firstOperand - secondOperand;
        long sum = (long) firstOperand + secondOperand;
        return switch (operation) {
            case 0 -> multiply;
            case 1 -> subtraction;
            default -> sum;
        };
    }

    public static boolean checkAnswer(long correctAnswer, String userAnswer) {
        if (userAnswer.equals(Long.toString(correctAnswer))) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, Long.toString(correctAnswer));
            return false;
        }
    }
}
