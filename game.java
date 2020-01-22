import java.util.Random;
import java.util.Scanner;

class game implements global
{
    board gameBoard;
    player playerX;
    player playerO;
    int turn;
    boolean done;
    
    public game() {
        this.done = false;
        final Scanner scanner = new Scanner(System.in);
        this.gameBoard = new board();
        String s = "player1";
        String str = "player2";
        int nextInt = 0;
        System.out.println("--------------------------------------");
        System.out.println("XoXoXoooo     Tic            ooooXoXoX");
        System.out.println("XoXoXoooo         Tac        ooooXoXoX");
        System.out.println("XoXoXoooo            Toe     ooooXoXoX");
        System.out.println("--------------------------------------\n");

        while (!this.done) {
            System.out.println("GameBot: Welcome to TicTacToe for the Java 212 Kobti class.");
            System.out.println("GameBot: Please select a game option: [1] Human vs Human [2] Human vs AI [3] AI vs AI");
            nextInt = scanner.nextInt();
            switch (nextInt) {
                case 1: {
                    System.out.print("GameBot: Please enter human player X name: ");
                    s = scanner.next().trim();
                    System.out.print("GameBot: Please enter human player O name: ");
                    str = scanner.next().trim();
                    this.done = true;
                    continue;
                }
                case 2: {
                    System.out.print("GameBot: Please enter human player X name: ");
                    s = scanner.next().trim();
                    System.out.print("GameBot: Please enter AI player O name: ");
                    scanner.next().trim();
                    System.out.println("NandiBot: yeah...right! you many not name me... I AM KobtiBot");
                    System.out.println("NandiBot: don't worry " + s + ", my level of difficulty is set to NOVICE!\n");
                    str = "NandiBot";
                    this.done = true;
                    continue;
                }
                case 3: {
                    System.out.print("GameBot: Please enter Novice AI player X name: ");
                    s = scanner.next().trim();
                    System.out.print("GameBot: Please enter Advanced AI player O name: ");
                    str = scanner.next().trim();
                    this.done = true;
                    continue;
                }
                default: {
                    System.out.println("GameBot: Please enter a valid selection...");
                    continue;
                }
            }
        }
        if (nextInt == 1) {
            this.playerX = (player)new HumanPlayer(this.gameBoard, 1, s);
            this.playerO = (player)new HumanPlayer(this.gameBoard, 2, str);
        }
        else if (nextInt == 2) {
            this.playerX = (player)new HumanPlayer(this.gameBoard, 1, s);
            this.playerO = new AdvancedAIPlayer(this.gameBoard, 2, str);
        }
        else {
            this.playerX = new AIPlayer(this.gameBoard, 1, s);
            this.playerO = new AdvancedAIPlayer(this.gameBoard, 2, str);
        }
        System.out.println("GameBot: Game initiated: " + s + " VS. " + str + "\n");
    }
    
    public void start() {
        final Random random = new Random();
        int i = 0;
        this.turn = random.nextInt(2) + 1;
        if (this.turn == 1) {
            System.out.println("GameBot: " + this.playerX.playerName + " wins the coin toss... X will start\n");
        }
        else {
            System.out.println("GameBot: " + this.playerO.playerName + " wins the coin toss... O will start\n");
        }
        while (i == 0) {
            if (this.turn == 1) {
                System.out.println("GameBot: Player X's Turn, go ahead " + this.playerX.playerName + ":");
                this.playerX.play(this.gameBoard);
            }
            else {
                System.out.println("GameBot: Player O's Turn, go ahead " + this.playerO.playerName + ":");
                this.playerO.play(this.gameBoard);
            }
            if (this.gameBoard.getState() != 0) {
                i = 1;
            }
            if (i == 0) {
                if (this.turn == 1) {
                    this.turn = 2;
                }
                else {
                    this.turn = 1;
                }
            }
        }
        this.gameBoard.displayBoard();
        if (this.gameBoard.getState() == 3) {
            System.out.println("GameBot: It is a DRAW! no winner...");
        }
        else if (this.turn == 1) {
            System.out.println("GameBot: The winner is player " + this.playerX);
        }
        else {
            System.out.println("GameBot: The winner is player " + this.playerO);
        }
    }
}