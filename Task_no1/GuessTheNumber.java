import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            // Decorative line before the game starts
            System.out.println("=============================================");
            System.out.println("||           Welcome to Guess the Number   ||");
            System.out.println("=============================================");

            int minRange = 1;
            int maxRange = 100;
            int attempts = 0;
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            boolean guessedCorrectly = false;

            System.out.println("I've picked a number between " + minRange + " and " + maxRange + ". Can you guess it?");

            while (!guessedCorrectly) {
                System.out.println("---------------------------------------------");
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts!");
                    guessedCorrectly = true;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (!guessedCorrectly && attempts >= 10) {
                    System.out.println("You've reached the maximum number of attempts.");
                    System.out.println("The correct number was: " + randomNumber);
                    break;
                }
            }

            // Decorative line after the game ends
            System.out.println("---------------------------------------------");
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            playAgain = playAgainChoice.equals("yes") || playAgainChoice.equals("y");
        }

        // Decorative line at the end of the program
        System.out.println("=============================================");
        System.out.println("||      Thanks for playing Guess the Number ||");
        System.out.println("=============================================");
        scanner.close();
    }
}
