package src.struct;

import java.util.*;

public class Player {
    private String name;
    private char symbol;
    private Board board;
    private Scanner in = new Scanner(System.in);

    //variables
    private int x;
    private int y;

    public Player(String name,char symbol,Board board){
        this.name= name;
        this.symbol = symbol;
        this.board = board;
    }

    public char getSymbol(){
        return symbol;
    }

    public int[] manualInput(){
        System.out.println(name+ " enter x any y co-ordinates");
        x=in.nextInt();
        y=in.nextInt();

        return new int[]{x,y};
    }

    public int[] AIInput(){
        //ai movement to block player winning
        for(int i=0;i<3;i++){
            //check rows
            if(board.checkEmpty(i, 0) && board.grid[i][1]=='X' && board.grid[i][2]=='X'){
                return new int[]{i,0}; //block left
            }
            if(board.checkEmpty(i, 1) && board.grid[i][0]=='X' && board.grid[i][2]=='X'){
                return new int[]{i,1}; //block middle
            }

            //check columns
            if(board.checkEmpty(0, i) && board.grid[1][i]=='X' && board.grid[2][i]=='X'){
                return new int[]{0,i}; //block top
            }
            if(board.checkEmpty(2, i) && board.grid[0][i]=='X' && board.grid[1][i]=='X'){
                return new int[]{2,i}; //block bottom
            }
        }

        //ai movement in general
        Random random = new Random();
        x=random.nextInt(3);
        y=random.nextInt(3);
        
        System.out.println("Computer placed "+symbol+" at "+ x+","+y);

        return new int[]{x,y};
    }
}
