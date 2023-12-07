package new_game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

abstract class Player {
    protected String name;
    protected char symbol;
    protected int scoreTracker;

    // Constructor
    public Player(String name, char symbol, int scoreTracker) {
        this.name = name;
        this.symbol = symbol;
        this.scoreTracker = scoreTracker;
    }

    public void playername() {
        System.out.println("Player's name: " + this.name);
    }

    public void playerturn() {
        System.out.println("Player's turn: " + this.symbol);
    }

    public void movesound() {
        System.out.println("ticc");
    }

    // Override the toString() method
    @Override
    public String toString() {
        return "Player{name='" + name + "', symbol='" + symbol + "', scoreTracker=" + scoreTracker + "}";
    }

    // Override the equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj){ 
        return true;
        }
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return symbol == player.symbol && scoreTracker == player.scoreTracker && name.equals(player.name);
    }

    public int getScoreTracker() {
        return scoreTracker;
    }
    abstract public void makeMove(int row, int col);

    public void displayPlayerInfo() {
        System.out.println("Player's name: " + this.name);
        System.out.println("Player's symbol: " + this.symbol);
        System.out.println("Player's score: " + this.scoreTracker);
    }

    // Register a new player
    public static void registerPlayer(String name, char symbol) {
        String filePath = "C:\\Users\\nichh\\OneDrive\\Desktop\\Camte_class\\year2__term3\\OOC\\TICTACTOE\\src\\new_game\\playerInfo.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(name + "," + symbol + ",0");
            writer.newLine();
            System.out.println("Player registered successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Login function to find a player by name
    public static Player login(String name) {
        String filePath = "C:\\Users\\nichh\\OneDrive\\Desktop\\Camte_class\\year2__term3\\OOC\\TICTACTOE\\src\\new_game\\playerInfo.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] playerInfo = line.split(",");
                if (playerInfo.length == 3 && playerInfo[0].equals(name)) {
                    System.out.println("Login successful!");
                    char symbol = playerInfo[1].charAt(0);
                    int scoreTracker = Integer.parseInt(playerInfo[2]);
                    return new Player(name, symbol, scoreTracker) {
                        @Override
                        public void makeMove(int row, int col) {
                            // Implement move logic if needed
                        }
                    };
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Player not found. Please register.");
        return null;
    }
}