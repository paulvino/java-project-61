package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void gamesEngine(String rules, String[][] gameData) {
        String userName = Cli.getUserName();
        System.out.println(rules);
        for (int i = Utils.START_ROUND_NUMBER; i <= Utils.FINAL_ROUND; i++) {
            askQuestion(gameData[i][Utils.QUESTION_INDEX_IN_ARRAY]);
            String correctAnswer = gameData[i][Utils.CORRECT_ANSWER_INDEX_IN_ARRAY];
            String userAnswer = getAnswer();
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                if (i == Utils.FINAL_ROUND) {
                    System.out.println("Congratulations, " + userName + "!");
                }
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer "
                        + "was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
    }

    public static void askQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static String getAnswer() {
        Scanner answer = new Scanner(System.in);
        System.out.print("Your answer: ");
        return answer.next();
    }
}
