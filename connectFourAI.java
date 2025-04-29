import java.util.Scanner;

public class connectFourAI {
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args){
        Board board = new Board();
        boolean running = true;
        int col;
        HumanPlayer player1 = new HumanPlayer(scanner,1);
        //HumanPlayer player2 = new HumanPlayer(scanner,2);
        MinMaxAI player3 = new MinMaxAI(2,1,0);
        MinMaxAI player4 = new MinMaxAI(1,2,0);


       // player3.getMoves(board);
        
        while (running) {
            col = player4.makeMove(board);
            board.dropPiece(col,1);
            System.out.println("--------------------------------------------");
            System.out.println(board);
            if(board.hasWon(1)){
                System.out.println("PLAYER "+1+" has won");
                break;
            };
            col = player3.makeMove(board);
            //System.out.println(col);
            board.dropPiece(col,2);
            System.out.println(board);
            if(board.hasWon(2)){
                System.out.println("PLAYER "+2+" has won");
                break;
            };

            if(draw(board)){
                break;
            }

        }
      
        
        
        

        



        System.out.println(board);
    }


    static boolean draw(Board board){
        int numCols = 7;
        int numRows =6;
        int emptySpace =0;
        int token1 = 1;
        int token2 = 2;
        // chcek that there is no empty spaces
        // then check that no one has won 
        for(int i=0;i<numRows;i++){
            for(int j=0;i<numCols;j++){
                if(board.board[i][j]==0)
                    return false;
            }
        }
        if(!board.hasWon(token2)&&!board.hasWon(token1)){
            System.out.println("draw");
            return true;
        }
        return false;
    }
    
    
}
