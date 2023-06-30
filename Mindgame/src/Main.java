import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Main {
    private static final int CODE_LENGTH = 4;
    private static final int NUM_COLORS = 6;
    static List<Integer> Guesses = new ArrayList<>(9);
    static List<List<Integer>> Feedbacks = new ArrayList<>(9);
    public static void main(String[] args) {
        List<Integer> secretCode = generateCode();
        System.out.println("Secret code: " + secretCode);
        System.out.println(firstGuess());
        Scanner scanner = new Scanner(System.in);
        String feedback = scanner.nextLine().trim();
        System.out.println(whatFeedback(feedback));
        Feedbacks.add(0, whatFeedback(feedback));
        String feedback1 = scanner.nextLine().trim();
        Feedbacks.add(1, whatFeedback(feedback1));
        System.out.println(Feedbacks);
        System.out.println(Feedbacks.get(0).get(1));
    }
    private static List<Integer> generateCode() {
        List<Integer> secretCode = new ArrayList<>();
        Random random = new Random();

        while (secretCode.size() < CODE_LENGTH) {
            int color = random.nextInt(NUM_COLORS) + 1;
            if (!secretCode.contains(color)) {
                secretCode.add(color);
            }
        }
        return secretCode;
    }
    public static List<Integer> firstGuess() {
        List<Integer> firstGuess = new ArrayList<>();
        firstGuess.add(1);
        firstGuess.add(2);
        firstGuess.add(3);
        firstGuess.add(4);
        return firstGuess;
    }
    public static List<Integer> whatFeedback(String userFeedback) {
        List<Integer> feedback = new ArrayList<>();
        String[] parts = userFeedback.split(" ");
        feedback.add(Integer.parseInt(parts[0]));
        feedback.add(Integer.parseInt(parts[2]));
        return feedback;
    }
    public static List<Integer> generateNextGuess() {
        List<Integer> nextGuess;
        nextGuess = generateCode();
        return nextGuess;
    }
    public static List<Integer> legitGuess(List<Integer> cGuess) {
        return cGuess;
    }
}
