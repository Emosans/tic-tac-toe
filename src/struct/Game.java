package src.struct;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    protected Player currentPlayer;

    //private variables
    int[] coOrdinates; 
    private int posPlayer1;
    private int posPlayer2;
    private int pos;

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
            // if(currentPlayer==player1)
            //     coOrdinates = currentPlayer.manualInput();
            // if(currentPlayer==player2)
            //     coOrdinates = currentPlayer.AIInput();
            
            // if(!board.checkEmpty(coOrdinates[0], coOrdinates[1]))
            //     continue;

            // //check if board pos is empty
            // if(board.checkEmpty(coOrdinates[0], coOrdinates[1]))
            //     board.makeMove(coOrdinates[0], coOrdinates[1], currentPlayer.getSymbol());

            
            
            
            // logic for bits for player
            if(currentPlayer==player1){
                pos = player1.bitInput();
                System.out.println("Player1 wants to occupy index pos "+pos);
                board.makeMoveWithBitsForPlayer(pos,currentPlayer);
            }
            if(currentPlayer == player2){
                pos = player2.AiInput();
                System.out.println("Player2 wants to occupy index pos "+pos);
                board.makeMoveWithBitsFoAI(pos, currentPlayer);            
            }
            
            System.out.println("positions occupied by player 1 "+board.formattedString); //binary form lsb is 0 ,msb is 8
            System.out.println("positions occupied by player 2 "+board.formattedString);
            
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
            
            //check if any player has won
            if(board.checkWin()) gameOver=true;
            

        } while(!gameOver);
        
    }
}
