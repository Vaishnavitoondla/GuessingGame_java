import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        int numRounds;

        System.out.print("Enter the number of rounds you want to play: ");
        numRounds = scanner.nextInt();

        for (int round = 1; round <= numRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int userGuess;
            int numAttempts = 0;
            int roundScore = 0;
            boolean isCorrect = false;

            System.out.println(
                    "Round " + round + ": I'm thinking of a number between 1 and 100. Can you guess what it is?");

            do {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                numAttempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Congratulations, you guessed the number!");
                    isCorrect = true;
                }
            } while (!isCorrect && numAttempts < 5);

            roundScore = 10 - (numAttempts - 1); // Calculate round score based on the number of attempts

            if (isCorrect) {
                System.out.println("Round " + round + " score: " + roundScore);
            } else {
                System.out.println("Round " + round + " score: 0");
            }

            totalScore += roundScore;
        }

        System.out.println("Total score: " + totalScore);
        scanner.close();
    }
}