public class Window{
    int[] window;
    int playerToken;
    int opponentToken;
    int emptyToken;
    int emptyCount;
    int playerCount;
    int enemyCount;
    Window(int[] window,int playerToken,int opponentToken,int emptyToken){
        this.window = window;
        this.playerToken = playerToken;
        this.opponentToken=opponentToken;
        this.emptyToken = emptyToken;
    }

    public int count(int token){
        int total =0;
        for(int cell:window){
            if(cell==token)
                total++;
        }
        return total;
    }

    public int windowEval(){
        playerCount = count(playerToken);
        enemyCount = count(opponentToken);
        emptyCount= count(emptyToken);
        //System.out.println(emptyCount+", "+playerCount+", "+enemyCount);

        
        
        if(playerCount ==3 && emptyCount == 1){
            
            return 15;
        }
        else if(enemyCount ==3 && emptyCount == 1){
            return -10;
        }
        else if(playerCount == 2&& emptyCount ==2){
            return 3;
        }
        
        else if(enemyCount ==2&& emptyCount==2){
            return -1;
        }
        else{
            return 0;
        }
        
        
        
    }
    
}