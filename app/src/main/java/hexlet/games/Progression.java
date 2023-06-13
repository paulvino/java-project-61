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

        int step = (int) (1 + (Math.random() * 8));
        int start = (int) (1 + (Math.random() * 15));
        int length = (int) (start + 5 + (Math.random() * 3));
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

    public static boolean checkAnswer(int answer, String userAnswer) {
        if (userAnswer.equals(Integer.toString(answer))) {
            Engine.resultGood();
            return true;
        } else {
            Engine.resultBad(userAnswer, Integer.toString(answer));
            return false;
        }
    }
}
