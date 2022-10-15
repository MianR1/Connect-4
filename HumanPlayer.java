import java.util.Scanner;
public class HumanPlayer extends Player{
    static char sym1 = 0;
    static char sym2 = 0;
    public HumanPlayer(char symbol, Board board, String name){
        super(symbol, board, name);

        if (sym1 == 0) {
            sym1 = symbol;
        } else {
            sym2 = symbol;
        }

    }
    int placement = 0;
    public void makeMove(Board board){
        char me;
        char enemy;
        me = sym1;
        if (sym2 != 0){
            enemy = sym2;
        }else{
            enemy = AIPlayer.sym1;
        }

        boolean bool = true;
        do{
            System.out.print("\n" + name + ", please input your move: ");

            Scanner scan = new Scanner(System.in);

            placement = scan.nextInt();

            int i = 5;
            if (0 < placement && placement < 8){
                while (bool) {
                    if (i == -1){
                        break;
                    }
                    if (board.arr[i][placement-1] == ' '){
                        board.arr[i][placement-1] = symbol;
                        bool = false;
                    } else {
                        i--;
                    }
                }
            }

            if (i == -1 || 1 > placement || placement > 7){
                System.out.println("Invalid Move!");
            }
        } while (bool);
    }
}
