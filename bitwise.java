import java.util.*;
public class bitwise {
    private int player1occupiedboard=0; 
    private int occupyPos;
    private int movebit;

    private Scanner in = new Scanner(System.in);

    //set player1 occupied values
    // 0-1-2-3-4-5-6-7-8 grids
    // suppose player inputs that he wants to input at pos 0
    // input the pos 0
    // perform bitwise 1 << pos 0 : ans = 00000001 -> 00000001
    // perform bitwise OR with movebit => 00000001
    // input the pos 2
    // perform bitwise on the bit pos 2 : ans = 00000001 -> 00000100
    // bitwise OR with movebit => 00000001 | 00000100 = 00000101 

    public void bits(){
        System.out.println("Enter a value betwewen 0-8 to occupy");
        occupyPos = in.nextInt();

        movebit = 1 << occupyPos;

        System.out.println(movebit);
        player1occupiedboard |= movebit;

        System.out.println("Player 1 board pos occupied : "+player1occupiedboard);
    }

    public static void main(String[] args){
        bitwise bit = new bitwise();
        bit.bits();
    }
}
