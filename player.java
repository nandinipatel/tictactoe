abstract class player
{
    public int playerSymbol;
    public board gameBoard;
    public String playerName;
    
    public abstract void play(final board p0);
    
    public player(final board gameBoard, final int playerSymbol, final String playerName) {
        this.gameBoard = gameBoard;
        this.playerSymbol = playerSymbol;
        this.playerName = playerName;
    }
    
    @Override
    public String toString() {
        return this.playerName;
    }
}