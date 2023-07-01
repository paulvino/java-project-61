package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int QUESTION_INDEX_IN_ARRAY = 0;
    public static final int CORRECT_ANSWER_INDEX_IN_ARRAY = 1;
    public static final int NUMBER_OF_ROUNDS_IN_GAME = 3;
    public static final int NUMBER_OF_ELEMENTS_FOR_GAME_ARRAY = 2;

    public static void runGameProcess(String rules, String[][] gameData) {
        System.out.println("Welcome to the Brain Games!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rules);

        for (int i = 0; i < NUMBER_OF_ROUNDS_IN_GAME; i++) {
            System.out.println("Question: " + gameData[i][QUESTION_INDEX_IN_ARRAY]);
            String correctAnswer = gameData[i][CORRECT_ANSWER_INDEX_IN_ARRAY];
            Scanner answer = new Scanner(System.in);
            System.out.print("Your answer: ");
            String userAnswer = answer.next();
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer "
                        + "was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
