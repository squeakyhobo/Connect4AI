public class Board{
    private int numRows = 6;
    private int numCols = 7;
    public int[][] board = new int[numRows][numCols];

    
    

    public Board(){
        
    }

    public Board(Board board,int col,int playerToken){
        for(int i =0;i<numRows;i++){
            this.board[i] = board.board[i].clone();
            
        }
        dropPiece(col, playerToken);
        
    }
    // simulate dropping a connect 4 piece with graviity then prints it at the end 
    public boolean dropPiece(int col,int playerToken){
        // check if you can  drop it there , if not ask to drop it again
        for(int i = numRows-1;i>=0;i--){
            if(board[i][col]==0){
                board[i][col]= playerToken;
                
                return true;
            }
        }
        System.out.println("column is full");
        return false;

    }
    public boolean canDropPiece(int col){
        for(int i = numRows-1;i>=0;i--){
            if(board[i][col]==0){
                
                
                return true;
            }
        }
        
        return false;
    }

    
    
    // check if any player have one 
    boolean hasWon(int playerToken){
        for(int i =0;i<numRows;i++){
            for(int j = 0;j<numCols;j++){
                if(board[i][j]==playerToken && (checkHorizontal(playerToken, j, i)||checkVertical(playerToken, j, i)||checkDiagonalRight(playerToken, j, i)||checkDiagonalLeft(playerToken, j, i))){
                    //System.out.println("player "+playerToken+" has won");
                    return true;
                }
            }
        }
        //System.out.println("no one has won yet");
        return false;
    }
    boolean checkHorizontal(int playerToken,int col,int row){
        return(col+3<numCols && board[row][col+1]== playerToken &&board[row][col+2]== playerToken&&board[row][col+3]== playerToken);
    }
    boolean checkVertical(int playerToken,int col,int row){
        return(row+3<numRows && board[row+1][col]== playerToken &&board[row+2][col]== playerToken&&board[row+3][col]== playerToken);
    }
    boolean checkDiagonalRight(int playerToken,int col, int row){   
        return(row+3<numRows && col+3<numCols && board[row+1][col+1]== playerToken &&board[row+2][col+2]== playerToken&&board[row+3][col+3]== playerToken);

    }
    boolean checkDiagonalLeft(int playerToken,int col, int row){   
        return(row+3<numRows && col-3>=0 && board[row+1][col-1]== playerToken &&board[row+2][col-2]== playerToken&&board[row+3][col-3]== playerToken);

    }
    boolean draw(){
        
        
        
        int token1 = 1;
        int token2 = 2;
        // chcek that there is no empty spaces
        // then check that no one has won 
        for(int i=0;i<numRows;i++){
            for(int j=0;i<numCols;j++){
                if(board[i][j]==0)
                    return false;
            }
        }
        if(!hasWon(token2)&&!hasWon(token1)){
            System.out.println("draw");
            return true;
        }
        return false;
    }

    public String toString(){
        String boardString ="";
        for(int[] column:board){
            for(int cell: column){
                boardString+= cell;
            }
            boardString+="\n";
        }
        return(boardString);
    }
    
}   