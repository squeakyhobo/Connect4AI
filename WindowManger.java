public class WindowManger {
    Board board;
    private int boardRows = 6;
    private int boardCols = 7;
    private int playerToken;
    private int opponentToken;
    private int emptyToken;
    WindowManger(Board board, int playerToken,int opponentToken,int emptyToken){
        this.board = board;
        this.playerToken = playerToken;
        this.opponentToken = opponentToken;
    }

    int boardEval(){
        int totalBoardEval = 0;
        for(int i = 0; i<boardRows;i++){
            for(int j =0;j<boardCols;j++){
                // deal wiht horizontal windows first 
                if(i+3<boardRows){
                    Window horizontalWindow = new Window(new int[]{board.board[i][j],board.board[i+1][j],board.board[i+2][j],board.board[i+3][j]}, playerToken, opponentToken,emptyToken);
                    totalBoardEval += horizontalWindow.windowEval();
                }
                if(j+3<boardCols){
                    Window verticalWindow = new Window(new int[]{board.board[i][j],board.board[i][j+1],board.board[i][j+2],board.board[i][j+3]}, playerToken, opponentToken,emptyToken);
                    totalBoardEval+= verticalWindow.windowEval();
                }
                if((i+3<boardRows&&j+3<boardCols)){
                    Window diagonalRightWindow =  new Window(new int[]{board.board[i][j],board.board[i+1][j+1],board.board[i+2][j+2],board.board[i+3][j+3]}, playerToken, opponentToken,emptyToken);
                    totalBoardEval += diagonalRightWindow.windowEval();

                }
                if(i+3<boardRows&& j-3>=0){
                    Window diagonalLeftWindow =  new Window(new int[]{board.board[i][j],board.board[i+1][j-1],board.board[i+2][j-2],board.board[i+3][j-3]}, playerToken, opponentToken,emptyToken);
                    totalBoardEval+= diagonalLeftWindow.windowEval();
                }
            }
        }
        return totalBoardEval;
    }
}
