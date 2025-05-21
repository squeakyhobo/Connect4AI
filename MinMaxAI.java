import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MinMaxAI implements Player {
    private int maxDepth;
    private int numRows = 6;
    private int numCols = 7;
    int nodes_visted;

    public int bestMove;
    public int token;
    public int opponentToken;
    private int emptyToken=0;


    public MinMaxAI(int token,int opponentToken,int emptyToken,int depth){
        this.token=token;
        this.opponentToken = opponentToken;
        this.emptyToken = emptyToken;
        this.maxDepth = depth;
    }
    @Override
    public int makeMove(Board board) {
        //minVal  = Integer.MAX_VALUE;
        //maxVal = Integer.MIN_VALUE;
        nodes_visted =0;
        bestMove = Math.max(-1, minMax(board, true, 0,Integer.MIN_VALUE,Integer.MAX_VALUE));
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
        int[] colWeight = new int[]{1,2,3,4,3,2,1};
      
        //int[] rowWeight = new int[]{0,1,2,3,4,5};
        int[] rowWeight = new int[]{0,0,0,0,0,0};
      

        for(int j = 0;j<numCols;j++){

            for(int i =0;i<numRows;i++){
                if(board[i][j] == token){
                    total+= colWeight[j]+rowWeight[i];
                }
                else if(board[i][j] == opponentToken){
                    total+= -(colWeight[j]+rowWeight[i]);
                }
                
            }

        }
        return total;


        
       
    }
    

    int minMax(Board board,boolean isMaxing,int depth,int alpha,int beta){
        int[] scores = new int[7];
        nodes_visted++;
      

        int bestScore;
        ArrayList<Integer> moves = getMoves(board);

        if(isMaxing){
           
            if(depth == maxDepth){
                return evaluation(board);
            }
            bestScore = Integer.MIN_VALUE;
            for(int move:moves){
                Board newBoard = new Board(board, move, token);
                if(newBoard.hasWon(token)){
                    if(depth==0){
                        return move;
                    }
                    return(1000-depth);
                }
                int score = minMax(newBoard , !isMaxing, depth+1,alpha,beta);
                alpha = Math.max(alpha, score);
                if (score>bestScore) {
                    bestScore = score;
                    if(depth==0){
                        bestMove = move;
                    
                    }
                }
                if(depth==0){
                    scores[move] = score;
                }
                if(beta<= alpha){ // means that 
                    //System.out.println("prunded at: "+depth);
                    break;

                }

            }
            
        }
        // must me min player 
        else{
           
            if(depth == maxDepth){
                return evaluation(board);
            }
            
            bestScore = Integer.MAX_VALUE;
            for(int move:moves){
                Board newBoard =new Board(board, move, opponentToken);
                if(newBoard.hasWon(opponentToken)){
                    return(-1000+depth);
                }
                int score = minMax(newBoard, !isMaxing, depth+1,alpha,beta);
                bestScore = Math.min(score, bestScore);
                beta = Math.min(beta, score);
                if(beta<= alpha){
                   // System.out.println("prunded at: "+depth);
                    break;
                }
            }
        }

        if (depth ==0){
            System.out.println(Arrays.toString(scores));
            return bestMove;

        }
        // d6System.out.println(bestScore);
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
