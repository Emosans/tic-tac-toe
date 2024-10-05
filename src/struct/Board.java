package src.struct;

public class Board{
    protected  char[][] grid;
    protected int player1BoardInfo = 0;
    protected int player2BoardInfo = 0;
    protected String formattedString;

    //winning combinations
    private static final int[] WINNING_COMBINATIONS = {
        0x007, // Row 1: 000000111
        0x038, // Row 2: 000111000
        0x1C0, // Row 3: 111000000
        0x049, // Column 1: 001001001
        0x092, // Column 2: 010010010
        0x124, // Column 3: 100100100
        0x111, // Diagonal 1: 100010001
        0x054  // Diagonal 2: 001010100
    };

    public Board(){
        grid = new char[3][3];
        //iterate through grid and initialise empty spaces
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j] = '-';
            }
        }
    }

    public boolean makeMoveWithBitsForPlayer(int pos,Player player){
        char symbol = player.getSymbol();
        int copyOfPlayerBoard;
        String binaryForm;

        int movebit = 1 << pos;

        if((player1BoardInfo & movebit) !=0){
            System.out.println("pos taken");
            return false;
        }

        player1BoardInfo |= movebit;
        copyOfPlayerBoard = player1BoardInfo;

        // make the index symbol X
        if(pos==0){
            grid[0][0] = symbol;
        } if(pos==1){
            grid[0][1] = symbol;
        } if(pos==2){
            grid[0][2] = symbol;
        } if(pos==3){
            grid[1][0] = symbol;
        } if(pos==4){
            grid[1][1] = symbol;
        } if(pos==5){
            grid[1][2] = symbol;
        } if(pos==6){
            grid[2][0] = symbol;
        } if(pos==7){
            grid[2][1] = symbol;
        } if(pos==8){
            grid[2][2] = symbol;
        } 

        binaryForm = Integer.toBinaryString(copyOfPlayerBoard);
        formattedString = String.format("%8s",binaryForm ).replace(' ', '0');
        return true;
    }

    public boolean makeMoveWithBitsFoAI(int pos,Player player){
        char symbol = player.getSymbol();
        int copyOfPlayerBoard;
        String binaryForm;

        int movebit = 1 << pos;

        if((player2BoardInfo & movebit) !=0){
            System.out.println("pos taken");
            return false;
        }

        player2BoardInfo |= movebit;
        copyOfPlayerBoard = player1BoardInfo;

        // make the index symbol X
        if(pos==0){
            grid[0][0] = symbol;
        } if(pos==1){
            grid[0][1] = symbol;
        } if(pos==2){
            grid[0][2] = symbol;
        } if(pos==3){
            grid[1][0] = symbol;
        } if(pos==4){
            grid[1][1] = symbol;
        } if(pos==5){
            grid[1][2] = symbol;
        } if(pos==6){
            grid[2][0] = symbol;
        } if(pos==7){
            grid[2][1] = symbol;
        } if(pos==8){
            grid[2][2] = symbol;
        } 

        binaryForm = Integer.toBinaryString(copyOfPlayerBoard);
        formattedString = String.format("%8s",binaryForm ).replace(' ', '0');
        return true;
    }

    public boolean makeMoveInBoard(int x,int y,char symbol){
        //check if space is empty '-'
        //if empty move can be made and then return true
        // if(grid[x][y] == '-'){
        //     grid[x][y] = symbol;
        //     return true;
        // }
        // return false;
        return false;

    }


    public boolean checkWin(){
        // for (int i = 0; i < 3; i++) {
        //     if ((grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) ||
        //         (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player)) {
        //         return true;
        //     }
        // }
        // return (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) ||
        //        (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player);

        // compare the bit string for player1boardinfo with winning
        for(int winMask : WINNING_COMBINATIONS){
            if((player1BoardInfo & winMask)==winMask){
                return true;
            }
        }
        return false;
    }

    public boolean checkEmpty(int x,int y){
        return grid[x][y] == '-';
    }

    public void displayBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println("");
        }
    }
}