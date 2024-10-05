package src.struct;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;

    //private variables
    int[] coOrdinates; 

    public Game(Player p1,Player p2){
        this.board = new Board();
        this.player1=p1;
        this.player2=p2;
        this.currentPlayer = player1;
    }

    public void play(){
        boolean gameOver=false;
        do{
            board.displayBoard();
    
            // ask player for his move
            if(currentPlayer==player1)
                coOrdinates = currentPlayer.manualInput();
            if(currentPlayer==player2)
                coOrdinates = currentPlayer.AIInput();
            
            if(!board.checkEmpty(coOrdinates[0], coOrdinates[1]))
                continue;

            //check if board pos is empty
            if(board.checkEmpty(coOrdinates[0], coOrdinates[1]))
                board.makeMove(coOrdinates[0], coOrdinates[1], currentPlayer.getSymbol());

            //check if any player has won
            if(board.checkWin(currentPlayer.getSymbol())) gameOver=true;

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        } while(!gameOver);
        
    }
}
