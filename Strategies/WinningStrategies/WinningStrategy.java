package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;

public interface WinningStrategy {
    boolean checkWinner(Move move, Board board);
}
