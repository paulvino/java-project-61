package hexlet.code;

import hexlet.games.Calculator;
import hexlet.games.Even;
import hexlet.games.GCD;
import hexlet.games.Progression;

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

            if (!flag) {
                roundNumber += 5;
            }

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
            int firstOperand = (int) (Math.random() * 20);
            int secondOperand = (int) (Math.random() * 20);
            Calculator.askQuestion(operation, firstOperand, secondOperand);
            String userAnswer = Engine.getAnswer();
            flag = Calculator.checkAnswer(operation, userAnswer, firstOperand, secondOperand);

            if (!flag) {
                roundNumber += 5;
            }

            roundNumber++;
        }

        Engine.gameEnding(roundNumber, userName);
    }

    public static void greatestCommonDivisorGame() {
        String userName = Engine.greeting();
        System.out.println("Find the greatest common divisor of given numbers.");

        boolean flag = true;
        int roundNumber = 1;
        while (flag && roundNumber <= 3) {
            int firstNumber = GCD.getFirstNumber();
            int secondNumber = GCD.getSecondNumber();
            GCD.askQuestion(firstNumber, secondNumber);
            String userAnswer = Engine.getAnswer();
            flag = GCD.checkAnswer(userAnswer, firstNumber, secondNumber);

            if (!flag) {
                roundNumber += 5;
            }

            roundNumber++;
        }

        Engine.gameEnding(roundNumber, userName);
    }

    public static void progressionGame() {
        String userName = Engine.greeting();
        System.out.println("What number is missing in the progression?");

        boolean flag = true;
        int roundNumber = 1;
        while (flag && roundNumber <= 3) {
            int correctAnswer = Progression.askQuestion();
            String userAnswer = Engine.getAnswer();
            flag = Progression.checkAnswer(correctAnswer, userAnswer);

            if (!flag) {
                roundNumber += 5;
            }

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
        if (roundNumber == 4) {
            System.out.println("Congratulations, " + userName + "!");
        } else {
            System.out.println("Let's try again, " + userName + "!");
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

    public static void resultBad(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer "
                + "was '" + correctAnswer + "'.");
    }
}
