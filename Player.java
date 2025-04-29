import java.util.Scanner;

public interface Player {
    
    
    public int makeMove(Board board);
}

class HumanPlayer implements Player{
    private Scanner scanner;
    private int playerToken;

    HumanPlayer(Scanner scanner,int playerToken){
        this.scanner=scanner;
        this.playerToken = playerToken;
        
    }
    @Override
    public int makeMove(Board board) {
        int col;
        System.out.println("player "+playerToken+" turn");    
        col = scanner.nextInt();
        while (!(col>=0 &&col<=7)) {
            System.out.println("move is not valid, try again");
            col = scanner.nextInt();
        }
        return col-1;
    }
    
}
