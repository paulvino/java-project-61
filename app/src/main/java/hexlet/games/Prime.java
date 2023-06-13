package hexlet.games;

import hexlet.code.Engine;

public class Prime {
    public static boolean primeEngine() {
        int questionPrime = Prime.askQuestion();
        String userAnswerPrime = Engine.getAnswer();
        return Prime.checkAnswer(questionPrime, userAnswerPrime);
    }
    public static int askQuestion() {
        int question = (int) (Math.random() * 100);
        System.out.println("Question: " + question);
        return question;
    }

    public static String correctAnswer(int question) {
        int counter = 0;
        for (int i = 1; i <= ((question / 2) + 1); i++) {
            if (question % i == 0) {
                counter++;
            }

            if (counter > 1) {
                return "no";
            }
        }
        return "yes";
    }

    public static boolean checkAnswer(int question, String userAnswer) {
        String correctAnswer = Prime.correctAnswer(question);

        if (correctAnswer.equals(userAnswer)) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, correctAnswer);
            return false;
        }
    }
}
