package hexlet.code;

import java.util.Scanner;

class Even {
    public static void isEvenGame() {
        String userName = Even.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        boolean flag = true;
        int tryNumber = 1;
        while (flag && tryNumber <= 3) {
            int question = Even.askQuestion();
            String userAnswer = Even.getAnswer();
            flag = Even.checkAnswer(question, userAnswer);
            tryNumber++;
            }

        if (tryNumber <= 3) {
            System.out.println("Let's try again, " + userName + "!");
        } else {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    static String greeting() {
        System.out.println("Welcome to the Brain Games!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        final String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    static int askQuestion() {
        int question = (int) (Math.random() * 100);
        System.out.println("Question: " + question);
        return question;
    }

    static String getAnswer() {
        Scanner answer = new Scanner(System.in);
        System.out.print("Your answer: ");
        return answer.next();
    }

    static boolean checkAnswer(int question, String userAnswer) {
        if ((question % 2 == 0 && "yes".equals(userAnswer)) ||
                (question % 2 != 0 && "no".equals(userAnswer))) {
            System.out.println("Correct!");
            return true;
        } else {
            String correctAnswer = question % 2 == 0 ? "yes" : "no";
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer " +
                    "was '" + correctAnswer + "'.");
            return false;
        }
    }
}
