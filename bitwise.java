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

    // public void bits(){
    //     System.out.println("Enter a value betwewen 0-8 to occupy");
    //     occupyPos = in.nextInt();

    //     movebit = 1 << occupyPos;

    //     System.out.println(movebit);
    //     player1occupiedboard |= movebit;

    //     System.out.println("Player 1 board pos occupied : "+player1occupiedboard);
    // }

    // public static void main(String[] args){
    //     bitwise bit = new bitwise();
    //     bit.bits();
    // }

    //avaible pos
    public int availablePos(int[] occupiedPos){
        List<Integer> availablePos = new ArrayList<>();
        for (int i=0;i<9;i++){
            availablePos.add(i);
        }
        System.out.println(availablePos);

        for (int occupied : occupiedPos){
            availablePos.remove(Integer.valueOf(occupied));
        }
        System.out.println("new available pos "+availablePos);

        Random random  = new Random();

        return random.nextInt(availablePos.size());
    }

    public int difCPUPos(){
        List<Integer> occupiedPos = new ArrayList<>();
        

        int y;

        occupiedPos.add(0);
        System.out.println(occupiedPos);

        // for(int i=0;i<3;i++){
        //     for(int j=0;j<3;j++){
        //         if(!board.checkEmpty(i, j)){
        //             System.out.println("Pos occupied trying different pos");
        //             // y = availablePos(i)
        //             if(i==0 && j==0){
        //                 occupiedPos.add(0);
        //             }
        //             if(i==0 && j==1){
        //                 occupiedPos.add(1);
        //             }
        //             if(i==0 && j==2){
        //                 occupiedPos.add(2);
        //             }
        //             if(i==1 && j==0){
        //                 occupiedPos.add(3);
        //             }
        //             if(i==1 && j==1){
        //                 occupiedPos.add(4);
        //             }
        //             if(i==1 && j==2){
        //                 occupiedPos.add(5);
        //             }
        //             if(i==2 && j==0){
        //                 occupiedPos.add(6);
        //             }
        //             if(i==2 && j==1){
        //                 occupiedPos.add(7);
        //             }
        //             if(i==2 && j==2){
        //                 occupiedPos.add(8);
        //             }


        //             for (int o=0;o<occupiedPos.size();o++){
        //                 copyOfList[o] = occupiedPos.get(o);
        //             }

        //             y=availablePos(copyOfList);
        //         }

        //         if(board.checkEmpty(i, j)){
        //             Random random = new Random();
        //             y=random.nextInt(8);
        //             return y;
        //         }
        //     }
        // }

        int[] copyOfList = new int[occupiedPos.size()];
        for(int i=0;i<occupiedPos.size();++i){
            copyOfList[i] = occupiedPos.get(i);
        }
        System.out.println(copyOfList);
        y=availablePos(copyOfList);


    return y;
    }



    public static void main(String args[]){
        bitwise bit = new bitwise();
        int newPos=bit.difCPUPos();
        // should not be 0
        System.out.println(newPos);
    }
}
