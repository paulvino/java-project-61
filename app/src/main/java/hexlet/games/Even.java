package hexlet.games;

public class Even {
    public static int askQuestion() {
        int question = (int) (Math.random() * 100);
        System.out.println("Question: " + question);
        return question;
    }

    public static boolean checkAnswer(int question, String userAnswer) {
        if ((question % 2 == 0 && "yes".equals(userAnswer))
                || (question % 2 != 0 && "no".equals(userAnswer))) {
            System.out.println("Correct!");
            return true;
        } else {
            String correctAnswer = question % 2 == 0 ? "yes" : "no";
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer "
                    + "was '" + correctAnswer + "'.");
            return false;
        }
    }
}
