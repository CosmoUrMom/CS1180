
/**
 * @author Rasheed Abbasov
 * @since 10/18/2024
 */

import java.util.Random;
import java.util.Scanner;

public class App {

    static int score = 0; // Needed to access this number in main and if forced me to make it static using
    // quick fix

    public static void main(String[] args) throws Exception {

        // Assigning a object to the Scanner and Random Class
        Scanner work = new Scanner(System.in);
        Random rand = new Random();

        String difficulty;
        boolean playAgain = false;
        String askAgain;

        // The outer do while loop is to make sure if the user wants to play again it
        // runs everything from the start
        // It controls all the nested loops
        do {
            System.out.println("Lets play Simon Says!");
            // This do while loop asks the user for what difficulty they want and makes sure
            // they give a proper input
            // When they choose a certain mode it calles the method that is designated with
            // that mode so the user can play the game
            // After the user played the game it prints out their score and resets teh score
            // variable
            do {
                System.out.println("Select difficulty (Easy or Hard)");
                difficulty = work.nextLine();
                if (difficulty.equalsIgnoreCase("easy")) {
                    System.out.println("Nice!");
                    easySimon();
                    System.out.println("Round over your score was: " + score);
                    score = 0;
                } else if (difficulty.equalsIgnoreCase("hard")) {
                    System.out.println("Nice!");
                    hardSimon();
                    System.out.println("Round over your score was: " + score);
                    score = 0;
                } else {
                    System.out.println("Invalid difficulty");
                }
            } while ((!difficulty.equalsIgnoreCase("Easy") && !difficulty.equalsIgnoreCase("Hard")) && !playAgain);

            // This do while loop runs when the users game has ended and it asks them if
            // they want to play again
            // It checks to see their input if it is proper if not it keeps asking until it
            // is
            // If they dont want to play again the loop is ended
            do {
                System.out.println("Do you want to play again?");
                askAgain = work.nextLine();
                if (askAgain.equalsIgnoreCase("yes")) {
                    playAgain = true;
                } else if (askAgain.equalsIgnoreCase("no")) {
                    playAgain = false;
                } else {
                    System.out.println("invalid input");
                }
            } while (!askAgain.equalsIgnoreCase("yes") && !askAgain.equalsIgnoreCase("no"));
        } while (playAgain);
    }

    /**
     * This method implements a easy version of a Simon Says game
     * The method prints out random colors (green, yellow, blue red)
     * The method makes sure to print out the previous color along with
     * a new one until the user gets a round wrong.
     * It makes sure to that it removes any spaces and the casing of the words
     * do not matter. (Gr eE nY ell ow, would be the same as greenyellow)
     * when the user gets the answer right it it addes +1 to the score.
     */
    public static void easySimon() {
        Scanner work = new Scanner(System.in);
        Random rand = new Random();
        String color = "";
        String userInput;
        do {
            int randNum = rand.nextInt(4);

            switch (randNum) {
                case 0:
                    color += " green";
                    break;
                case 1:
                    color += " yellow";
                    break;
                case 2:
                    color += " blue";
                    break;
                case 3:
                    color += " red";
                    break;
            }
            System.out.println("Simon Says:" + color);
            clearScreen();
            userInput = removeSpace(work.nextLine());
            if (userInput.equalsIgnoreCase(removeSpace(color))) {
                score++;
            }
            System.out.println("Score: " + score);
        } while (userInput.equalsIgnoreCase(removeSpace(color)));
    }

    /**
     * The method hardSimon is really similar to easySimon.
     * The differences are that instead of using colors it uses numbers, and
     * the amount of random options are more (0-9).
     */
    public static void hardSimon() {
        Scanner work = new Scanner(System.in);
        Random rand = new Random();
        String numberHolder = "";
        String userInput;

        do {
            int randomNumber = rand.nextInt(10);

            switch (randomNumber) {
                case 0:
                    numberHolder += " 0";
                    break;
                case 1:
                    numberHolder += " 1";
                    break;
                case 2:
                    numberHolder += " 2";
                    break;
                case 3:
                    numberHolder += " 3";
                    break;
                case 4:
                    numberHolder += " 4";
                    break;
                case 5:
                    numberHolder += " 5";
                    break;
                case 6:
                    numberHolder += " 6";
                    break;
                case 7:
                    numberHolder += " 7";
                    break;
                case 8:
                    numberHolder += " 8";
                    break;
                case 9:
                    numberHolder += " 9";
                    break;
            }

            System.out.println("Simon Says:" + numberHolder);
            clearScreen();
            userInput = removeSpace(work.nextLine());
            if (userInput.equalsIgnoreCase(removeSpace(numberHolder))) {
                score++;
            }
            System.out.println("Score: " + score);
        } while (userInput.equalsIgnoreCase(removeSpace(numberHolder)));
    }

    /**
     * Removes spaces from the user input String
     * 
     * The method goes through the string and checks each character one by one.
     * If the char that it is checking is a (" ") it removes it by doing ("").
     * 
     * 
     * 
     * @param s the input the user will enter so that the spaces can be removed from
     *          it
     * @return the method retuns a new string that from what the user entere but
     *         without the spaces
     * 
     */
    public static String removeSpace(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                result += s.charAt(i);
            }
        }
        return result;
    }

    /**
     * Was given by the professor
     */
    public static void clearScreen() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
