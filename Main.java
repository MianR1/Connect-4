public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new AIPlayer('R', board, "Alice"));
        game.setPlayer2(new AIPlayer('B', board, "Bob"));
        game.playGame();
    }
}
