package hexlet.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static void evenGame() {
        String userName = Cli.getUserName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        boolean flag = true;
        int roundNumber = Utils.START_ROUND_NUMBER;
        while (flag && roundNumber <= Utils.FINAL_ROUND) {
            flag = Even.evenEngine();
            roundNumber++;
        }

        if (!flag) {
            roundNumber += Utils.ROUND_NUMBER_FOR_MISTAKES;
        }

        Engine.gameEnding(roundNumber, userName);
    }

    public static boolean evenEngine() {
        int question = Even.askQuestion();
        String correctAnswer = Even.getCorrectAnswer(question);
        String userAnswerEven = Engine.getAnswer();
        return Even.checkAnswer(correctAnswer, userAnswerEven);
    }

    public static int askQuestion() {
        int question = (int) (Math.random() * Utils.BORDER_100);
        System.out.println("Question: " + question);
        return question;
    }

    public static String getCorrectAnswer(int question) {
        return question % 2 == 0 ? "yes" : "no";
    }

    public static boolean checkAnswer(String correctAnswer, String userAnswer) {

        if (correctAnswer.equals(userAnswer)) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, correctAnswer);
            return false;
        }
    }
}
