package new_game;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create Player 1
        System.out.println("Player 1 Registration:");
        registerAndLoginPlayer();

        // Create Player 2
        System.out.println("\nPlayer 2 Registration:");
        registerAndLoginPlayer();

        scanner.close();
    }

    // Function to register and login a player
    private static void registerAndLoginPlayer() {
        System.out.print("Enter player name: ");
        String playerName = scanner.next();

        //single character as a symbol
        System.out.print("Enter player symbol (single character): ");
        char playerSymbol = scanner.next().charAt(0);

        Player.registerPlayer(playerName, playerSymbol);
        Player player = Player.login(playerName);

        if (player != null) {
            System.out.println("Player Information:");
            player.displayPlayerInfo();
        }
    }
}
