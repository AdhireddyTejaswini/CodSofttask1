import java.util.Random;
import java.util.Scanner;


public class NumberGuessingGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "yes";
        int rounds = 0;
        int totalAttempts = 0;

        while (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y")){
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            rounds++;

            System.out.println("\nRound " + rounds + ":");
            System.out.println("I'm thinking of a number between 1 and 100.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = scanner.nextInt();
                } catch (Exception e){
                    System.out.println("Please enter a vaild number.");
                    scanner.next();
                    continue;
                }

                attempts++;
                totalAttempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else if (guess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("congratulations! You guessed the number in "+ attempts + "attempts.");
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all " + maxAttempts + "attempts. The number was " + randomNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        }

        System.out.println("\nGame over! You played " + rounds + "round(s) with a total of " + totalAttempts + "attempts.");
        double averageAttempts = (double) totalAttempts / rounds;
        System.out.println("Average attempts per round: " + String.format("%.2f", averageAttempts));

        scanner.close();
    }
}