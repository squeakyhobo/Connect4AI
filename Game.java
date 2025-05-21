public class Game {
    Player player1;
    Player player2;
    Board board;
    int token1;
    int token2;
    int emptyToken;


    public Game(Player player1,Player player2,Board board,int token1,int token2, int emptyToken){

        this.player1 = player1;
        this.player2 = player2;
        this.token1=token1;
        this.token2 = token2;
        this.emptyToken = emptyToken;
        this.board = board;
        

    }

    public void game(){
        while (true) {
            int move = player1.makeMove(board);
            board.dropPiece(move, token1);
            System.out.println(board);
            if(board.hasWon(token1)){
                System.out.println("player one has won");
                break;
            }
            if (board.draw()){
                break;
            }

            move = player2.makeMove(board);
            board.dropPiece(move, token2);
            System.out.println(board);
            if(board.hasWon(token2)){
                System.out.println("player two has won");
                break;
            }
            if (board.draw()){
                break;
            }
        }
    }
}
