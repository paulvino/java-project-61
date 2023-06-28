package hexlet.code;

public class Utils {
    public static int getRandomNumber(int start, int finish) {
        int number = (int) (start + (Math.random() * finish));
        return number;
    }
}
