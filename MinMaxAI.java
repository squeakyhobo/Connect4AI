import java.util.ArrayList;

public class MinMaxAI implements Player {
    private int maxDepth = 5;
    private int numRows = 6;
    private int numCols = 7;
    int nodes_visted;

    public int bestMove;
    public int token;
    public int opponentToken;
    private int emptyToken=0;


    public MinMaxAI(int token,int opponentToken,int emptyToken){
        this.token=token;
        this.opponentToken = opponentToken;
        //this.emptyToken = emptyToken;
    }
    @Override
    public int makeMove(Board board) {
        //minVal  = Integer.MAX_VALUE;
        //maxVal = Integer.MIN_VALUE;
        nodes_visted =0;
        bestMove = Math.max(-1, minMax(board, true, 0));
        System.out.println("nodes visteed: "+nodes_visted);
        System.out.println("best move: "+(bestMove+1) );
        return bestMove;
        
    }

    
    int evaluation(Board board){
        int total =0;

        WindowManger windowManger = new WindowManger(board, token, opponentToken, emptyToken);
        total += centreEval(board.board);
         total+=windowManger.boardEval();
         //System.out.println(total);
         return total;

    }
    int centreEval(int[][] board){
        int total =0;
        int[] weight = new int[]{0,2,5,7,5,2,0};
        int[] opponentWeight = new int[]{0,-2,-5,-7,-5,-2,0};

        for(int j = 0;j<numCols;j++){

            for(int i =0;i<numRows;i++){
                if(board[i][j] == token){
                    total+= weight[j];
                }
                else if(board[i][j] == opponentToken){
                    total+= opponentWeight[j];
                }
                
            }

        }
        return total;


        
       
    }
    

    int minMax(Board board,boolean isMaxing,int depth){
        // base case
        nodes_visted++;
      

        int bestScore;
        ArrayList<Integer> moves = getMoves(board);

        if(isMaxing){
            if(board.hasWon(opponentToken)){
                
                return(-1000);
            }
            if(depth == maxDepth){
                return evaluation(board);
            }
            bestScore = Integer.MIN_VALUE;
            for(int move:moves){
                int score = minMax(new Board(board, move, token), !isMaxing, depth+1);
                if (score>bestScore) {
                    bestScore = score;
                    if(depth==0){
                        bestMove = move;
                    }
                }


            }
            
        }
        // must me min player 
        else{
            if(board.hasWon(token)){
                System.out.println("you have won");
                return(1000);
            }
            if(depth == maxDepth){
                return evaluation(board);
            }
            
            bestScore = Integer.MAX_VALUE;
            for(int move:moves){
                int score = minMax(new Board(board, move, opponentToken), !isMaxing, depth+1);
                bestScore = Math.min(score, bestScore);
            }
        }

        if (depth ==0){
            return bestMove;
        }
        System.out.println(bestScore);
        return bestScore;
        
    }

    ArrayList<Integer> getMoves(Board board){
        ArrayList<Integer> moves = new ArrayList<>();
        
        for(int i = 0; i < numCols;i++){
            if(board.canDropPiece(i)){
                moves.add(i);
            }
        }
        //System.out.println(moves);
        return moves;
    }


    
  
   

    
}
