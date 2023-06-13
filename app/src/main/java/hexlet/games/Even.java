package hexlet.games;

import hexlet.code.Engine;

public class Even {
    public static boolean evenEngine() {
        int questionEven = Even.askQuestion();
        String userAnswerEven = Engine.getAnswer();
        return Even.checkAnswer(questionEven, userAnswerEven);
    }

    public static int askQuestion() {
        int question = (int) (Math.random() * 100);
        System.out.println("Question: " + question);
        return question;
    }

    public static String correctAnswer(int question) {
        return question % 2 == 0 ? "yes" : "no";
    }

    public static boolean checkAnswer(int question, String userAnswer) {
        String correctAnswer = Even.correctAnswer(question);

        if (correctAnswer.equals(userAnswer)) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, correctAnswer);
            return false;
        }
    }
}
