import java.util.ArrayList;

public class MinMaxAI implements Player {
    private int maxDepth = 2;
    @Override
    public int makeMove() {
        // add the recurive function here 
        return 0;
    }

    
    int evaluation(int[][] board){
        return 0;
    }

    int minMax(Board board,boolean isMaxing,int depth,int playerToken){
        // base case
        if(depth == maxDepth){
            return evaluation(null);

        }
        else{
            // genertate all possible moves from current state and apply move
            ArrayList<Integer> moves = getMoves(board);
            for(int move : moves){
                
                return(minMax(new Board(board,move,playerToken), !isMaxing, depth+1,playerTokenInverter(playerToken)));
            }
        }
        // get aviable moves
        // then go thought each move to go to next mov euntil max depth reached then evaulate score and ...
        return 0;
    }

    ArrayList<Integer> getMoves(Board board){
        ArrayList<Integer> moves = new ArrayList<>();
        int numCols = 7;
        for(int i = 0; i < numCols;i++){
            if(board.canDropPiece(i)){
                moves.add(i);
            }
        }
        System.out.println(moves);
        return moves;
    }

    int playerTokenInverter(int playerToken){
        if(playerToken==1)
        return 2;
        else if (playerToken ==2){
            return 1;

        }
        else{
            System.out.println("error");
            return -1;
        }
    }
}
