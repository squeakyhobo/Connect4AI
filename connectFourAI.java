import java.util.Scanner;

public class connectFourAI {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        Board board = new Board();
        boolean running = true;
        int col;
        HumanPlayer player1 = new HumanPlayer(scanner,1);
        HumanPlayer player2 = new HumanPlayer(scanner,2);
        MinMaxAI player3 = new MinMaxAI();
        player3.getMoves(board);
        
        while (running) {
            col = player1.makeMove();
            board.dropPiece(col,1);
            System.out.println(board);
            if(board.hasWon(1)){
                break;
            };
            col = player2.makeMove();
            board.dropPiece(col,2);
            System.out.println(board);
            if(board.hasWon(2)){
                break;
            };

        }
      
        
        
        

        



        System.out.println(board);
    }
    
    
}
