public class AIPlayer extends Player{
    static char sym1 = 0;
    static char sym2 = 0;

    public AIPlayer(char symbol, Board board, String name){
        super(symbol, board, name);

        if (sym1 == 0) {
            sym1 = symbol;
        } else {
            sym2 = symbol;
        }
    }
    public void makeMove(Board board){
        char me;
        char enemy;
        me = sym1;
        if (sym2 != 0){
            enemy = sym2;
        }else{
            enemy = HumanPlayer.sym1;
        }

        if (winningMove() != -1) { //checks for winning moves or possible blocks
            board.arr[isEmpty(winningMove())][winningMove()] = this.symbol;
        } else { // random num generator
            boolean notFound = true;

            while(notFound){

                int rand = (int)(Math.random()*(6+1)+0);

                int row = isEmpty(rand);

                if (row != -1) {
                    board.arr[row][rand] = symbol;
                    notFound = false;
                }
            }
        }
    }
    public int winningMove() {
        char me;
        char enemy;
        me = sym1;
        if (sym2 != 0){
            enemy = sym2;
        }else{
            enemy = HumanPlayer.sym1;
        }

        // move decision
        if (me == symbol){
            if (wMoveSym(me) != -1){
                return wMoveSym(me);
            } else if (wMoveSym(enemy) != -1){
                return wMoveSym(enemy);
            }
        } else {
            if (wMoveSym(enemy) != -1){
                return wMoveSym(enemy);
            }
            else if (wMoveSym(me) != -1){
                return wMoveSym(me);
            }
        }
        return -1;

    }
    public int wMoveSym(char playerSym) {
        int winOne; int empty; int clmNum; int rowNum;

        // Horizontal
        for (int x = 5; x >= 0; x--)
        {
            for (int i = 0; i <= 3; i++){
                winOne = 0;
                empty = 0;
                clmNum = 0;
                for (int y = 6-i; y >= 3-i; y--){
                    if (board.arr[x][y] == playerSym){
                        winOne += 1;
                    } else if (board.arr[x][y] == ' ') {
                        empty += 1;
                        clmNum = y;
                    }
                    if (winOne == 3 && empty == 1 && under(x,clmNum)){
                        return clmNum;
                    }
                }
            }
        }
        // Vertical
        for (int y = 0; y <= 6; y++){
            empty = 0;
            clmNum = 0;
            for (int i = 0; i <= 2; i++){
                winOne = 0;
                for (int x = 5-i; x >= 2-i; x--){
                    if (board.arr[x][y] == playerSym){
                        winOne += 1;
                    }
                    else if (board.arr[x][y] == ' ') {
                        empty += 1;
                        clmNum = y;
                    }
                    if (winOne == 3 && empty == 1){
                        return clmNum;
                    }
                }
            }
        }

        for (int z = 0; z <= 2;z++){
            // right diagonals
            for (int i = 0; i <= 3; i++){
                winOne = 0;
                empty = 0;
                clmNum = 0;
                rowNum = 0;

                for (int x = 5-z, y = i ; x >= 2-z; x--, y++) {
                    if (board.arr[x][y] == playerSym){
                        winOne += 1;
                    } else if (board.arr[x][y] == ' ') {
                        empty += 1;
                        clmNum = y;
                        rowNum = x;
                    }
                    if (winOne == 3 && empty == 1 && under(rowNum,clmNum)){
                        return clmNum;
                    }
                }
            }
            // left diagonals
            for (int i = 6; i >=3; i--){
                winOne = 0;
                empty = 0;
                clmNum = 0;
                rowNum = 0;

                for (int x = 5-z, y = i ; x >= 2-z; x--, y--) {
                    if (board.arr[x][y] == playerSym){
                        winOne += 1;
                    } else if (board.arr[x][y] == ' ') {
                        empty += 1;
                        clmNum = y;
                        rowNum = x;
                    }
                    if (winOne == 3 && empty == 1 && under(rowNum,clmNum)){
                        return clmNum;
                    }
                }
            }
        }
        return -1;
    }
    public boolean under(int rowNum, int clmNum) {
        for (int i = 5; i > rowNum; i--){
            if (board.arr[i][clmNum] == ' '){
                return false;
            }
        }
        return true;
    }
    public int isEmpty(int Column) {
        int i = 5;
        while (true) {
            if (i == -1){
                return -1;
            }
            if (board.arr[i][Column] == ' '){
                return i;
            } else {
                i--;
            }
        }
    }
}
