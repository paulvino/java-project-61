package hexlet.games;

import hexlet.code.Engine;

public class Progression {
    public static boolean progressionEngine() {
        int correctAnswer = Progression.askQuestion();
        String userAnswerProgression = Engine.getAnswer();
        return Progression.checkAnswer(correctAnswer, userAnswerProgression);
    }
    public static int askQuestion() {
        System.out.print("Question: ");

        final int numberOfStep = 8;
        int step = (int) (1 + (Math.random() * numberOfStep));
        final int numberOfBorderForStart = 15;
        int start = (int) (1 + (Math.random() * numberOfBorderForStart));
        final int numberForLength = 3;
        final int minNumbers = 5;
        int length = (int) (start + minNumbers + (Math.random() * numberForLength));
        int replace = (int) (Math.random() * length);
        int answer = 0;

        for (int i = 0; i <= length; i++) {
            if (i == replace) {
                System.out.print(".. ");
                answer = start;
                start += step;
            } else if (i == length) {
                System.out.println();
            } else {
                System.out.print(start + " ");
                start += step;
            }
        }
        return answer;
    }

    public static boolean checkAnswer(int correctAnswer, String userAnswer) {
        if (userAnswer.equals(Integer.toString(correctAnswer))) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, Integer.toString(correctAnswer));
            return false;
        }
    }
}
