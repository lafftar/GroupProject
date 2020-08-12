/** Runs the Card Game of War
 * @author Ashley Sun
 * @author Bryan Acorda
 * @author Tibabalase Oludemi
 */
package ca.sheridancollege.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        WarGame game = new WarGame("War");

        boolean playAgain = false;
        do {
            game.play();
            System.out.print("Do you want to play again? (Yes/No): ");
            String confirm = input.next();

            if (confirm.equalsIgnoreCase("yes")) {
                playAgain = true;
            } else {
                playAgain = false;
            }
        } while (playAgain);
        System.out.println("Have a good day!");
        WarGame.sleepForOneSecond();
    }
}

