import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPER_CASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|:;,.<>?";

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        String allChars = UPPER_CASE_CHARS + LOWER_CASE_CHARS + NUMBERS + SPECIAL_CHARS;

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allChars.length());
            char randomChar = allChars.charAt(index);
            password.append(randomChar);
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter the length of the password (0 to exit): ");
            int passwordLength = scanner.nextInt();
            scanner.nextLine(); 

            if (passwordLength == 0) {
                running = false;
                continue;
            }
            String password = generatePassword(passwordLength);
            System.out.println("Generated Password: " + password);
            System.out.println();
        }

        scanner.close();
    }
}
