package src.struct;

public class Board{
    protected  char[][] grid;

    public Board(){
        grid = new char[3][3];
        //iterate through grid and initialise empty spaces
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j] = '-';
            }
        }
    }

    public boolean makeMove(int x,int y,char symbol){
        //check if space is empty '-'
        //if empty move can be made and then return true
        if(grid[x][y] == '-'){
            grid[x][y] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkWin(char player){
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) ||
                (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player)) {
                return true;
            }
        }
        return (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) ||
               (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player);
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