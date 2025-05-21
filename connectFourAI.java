import java.util.Scanner;

public class connectFourAI {
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args){
        Board board = new Board();
        boolean running = true;
        int col;
        HumanPlayer human = new HumanPlayer(scanner,2);
        MinMaxAI bot = new MinMaxAI(1,2,0,7);
        Game game;
        


        System.out.println("IS BOT GOING FIRST OR SECOND");
        int turn = scanner.nextInt();
        if(turn==1){
            game = new Game(bot, human, board, bot.token, human.playerToken, 0);
            game.game();
        }

        else if (turn==2){
            game = new Game(human, bot, board, human.playerToken, bot.token, 0);
            game.game();
        }

        
        
        


       // player3.getMoves(board);
        
        
    }


    
    
    
}
