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
    private int posP1;
    private int posP2;

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
                posP1 = player1.bitInput();
                System.out.println("Player1 wants to occupy index pos "+posP1);
                board.makeMoveWithBitsForPlayer(posP1,currentPlayer);
            }
            if(currentPlayer == player2){
                posP2 = player2.difCPUPos("");
                int newPos;
                System.out.println(posP1==posP2);

                newPos = (posP1==posP2) ? player2.difCPUPos(Integer.toString(posP2)) : posP2;

                System.out.println("Player2 wants to occupy index pos "+posP2);
                board.makeMoveWithBitsForPlayer(newPos, currentPlayer);
                
            }

            // output the index positions already used
            System.out.println("positions occupied by player 1 "+board.formattedStringForPlayer1); //binary form lsb is 0 ,msb is 8
            System.out.println("positions occupied by player 2 "+board.formattedStringForPlayer2);
            
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
            
            //check if any player has won
            gameOver = board.checkWin() ? true : false;
            

        } while(!gameOver);
        
    }
}
