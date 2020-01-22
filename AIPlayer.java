import java.util.Random;

public class AIPlayer extends player implements global
{
    public AIPlayer(final board board, final int n, final String s) {
        super(board, n, s);
    }
    
    public void play(final board board) {
        final int randomLegal = this.randomLegal();
        board.makeMove(randomLegal, this.playerSymbol);
        System.out.println(this.playerName + ": hmm... just a random move at " + randomLegal);
    }
    
    private int senseWin() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (this.gameBoard.blocks[i][j].getState() == 0) {
                    int n = 0;
                    if (this.gameBoard.blocks[0][j].getState() == this.playerSymbol) {
                        ++n;
                    }
                    if (this.gameBoard.blocks[1][j].getState() == this.playerSymbol) {
                        ++n;
                    }
                    if (this.gameBoard.blocks[2][j].getState() == this.playerSymbol) {
                        ++n;
                    }
                    if (n == 2) {
                        return 3 * i + 1 + j;
                    }
                    int n2 = 0;
                    if (this.gameBoard.blocks[i][0].getState() == this.playerSymbol) {
                        ++n2;
                    }
                    if (this.gameBoard.blocks[i][1].getState() == this.playerSymbol) {
                        ++n2;
                    }
                    if (this.gameBoard.blocks[i][2].getState() == this.playerSymbol) {
                        ++n2;
                    }
                    if (n2 == 2) {
                        return 3 * i + 1 + j;
                    }
                    int n3 = 0;
                    if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                        if (this.gameBoard.blocks[0][2].getState() == this.playerSymbol) {
                            ++n3;
                        }
                        if (this.gameBoard.blocks[1][1].getState() == this.playerSymbol) {
                            ++n3;
                        }
                        if (this.gameBoard.blocks[2][0].getState() == this.playerSymbol) {
                            ++n3;
                        }
                        if (n3 == 2) {
                            return 3 * i + 1 + j;
                        }
                    }
                    int n4 = 0;
                    if ((i == 0 && j == 0) || (i == 1 && j == 1) || (i == 2 && j == 2)) {
                        if (this.gameBoard.blocks[0][0].getState() == this.playerSymbol) {
                            ++n4;
                        }
                        if (this.gameBoard.blocks[1][1].getState() == this.playerSymbol) {
                            ++n4;
                        }
                        if (this.gameBoard.blocks[2][2].getState() == this.playerSymbol) {
                            ++n4;
                        }
                        if (n4 == 2) {
                            return 3 * i + 1 + j;
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    private int senseLoss() {
        int n;
        if (this.playerSymbol == 1) {
            n = 2;
        }
        else {
            n = 1;
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (this.gameBoard.blocks[i][j].getState() == 0) {
                    int n2 = 0;
                    if (this.gameBoard.blocks[0][j].getState() == n) {
                        ++n2;
                    }
                    if (this.gameBoard.blocks[1][j].getState() == n) {
                        ++n2;
                    }
                    if (this.gameBoard.blocks[2][j].getState() == n) {
                        ++n2;
                    }
                    if (n2 == 2) {
                        return 3 * i + 1 + j;
                    }
                    int n3 = 0;
                    if (this.gameBoard.blocks[i][0].getState() == n) {
                        ++n3;
                    }
                    if (this.gameBoard.blocks[i][1].getState() == n) {
                        ++n3;
                    }
                    if (this.gameBoard.blocks[i][2].getState() == n) {
                        ++n3;
                    }
                    if (n3 == 2) {
                        return 3 * i + 1 + j;
                    }
                    int n4 = 0;
                    if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {
                        if (this.gameBoard.blocks[0][2].getState() == n) {
                            ++n4;
                        }
                        if (this.gameBoard.blocks[1][1].getState() == n) {
                            ++n4;
                        }
                        if (this.gameBoard.blocks[2][0].getState() == n) {
                            ++n4;
                        }
                        if (n4 == 2) {
                            return 3 * i + 1 + j;
                        }
                    }
                    int n5 = 0;
                    if ((i == 0 && j == 0) || (i == 1 && j == 1) || (i == 2 && j == 2)) {
                        if (this.gameBoard.blocks[0][0].getState() == n) {
                            ++n5;
                        }
                        if (this.gameBoard.blocks[1][1].getState() == n) {
                            ++n5;
                        }
                        if (this.gameBoard.blocks[2][2].getState() == n) {
                            ++n5;
                        }
                        if (n5 == 2) {
                            return 3 * i + 1 + j;
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    private int randomLegal() {
        int bound = 0;
        final int[] array = new int[9];
        final Random random = new Random();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (this.gameBoard.blocks[i][j].getState() == 0) {
                    array[bound++] = 3 * i + 1 + j;
                }
            }
        }
        return array[random.nextInt(bound)];
    }
}