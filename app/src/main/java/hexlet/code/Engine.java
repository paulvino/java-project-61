package hexlet.code;

import hexlet.games.Calculator;
import hexlet.games.Even;

import java.util.Scanner;

public class Engine {
    public static void isEvenGame() {
        String userName = Engine.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        boolean flag = true;
        int roundNumber = 1;
        while (flag && roundNumber <= 3) {
            int question = Even.askQuestion();
            String userAnswer = Engine.getAnswer();
            flag = Even.checkAnswer(question, userAnswer);
            roundNumber++;
        }
        Engine.gameEnding(roundNumber, userName);
    }

    public static void calculatorGame() {
        String userName = Engine.greeting();
        System.out.println("What is the result of the expression?");

        boolean flag = true;
        int roundNumber = 1;
        while (flag && roundNumber <= 3) {
            int operation = Calculator.getOperation();
            int first = Calculator.getFirstOperand();
            int second = Calculator.getSecondOperand();
            Calculator.askQuestion(operation, first, second);
            String userAnswer = Engine.getAnswer();
            flag = Calculator.checkAnswer(operation, userAnswer, first, second);
            roundNumber++;
        }
        Engine.gameEnding(roundNumber, userName);
    }


    public static String greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void gameEnding(int roundNumber, String userName) {
        if (roundNumber <= 3) {
            System.out.println("Let's try again, " + userName + "!");
        } else {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    public static String getAnswer() {
        Scanner answer = new Scanner(System.in);
        System.out.print("Your answer: ");
        return answer.next();
    }

    public static void resultGood() {
        System.out.println("Correct!");
    }
}
