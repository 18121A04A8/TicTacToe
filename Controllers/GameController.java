package TicTacToe.Controllers;

import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidMoveException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Models.Board;
import TicTacToe.Models.Game;
import TicTacToe.Models.GameState;
import TicTacToe.Models.Player;
import TicTacToe.Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) throws InvalidBotCountException, InvalidPlayerCountException {
        return Game.getBuilder().setDimention(3).setPlayers(players).setWinningStrategies(winningStrategies).Build();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove(game);
    }

    public GameState getGamestate(Game game) {
        return game.getGameState();
    }

    public void PrintBoard(Game game){
        game.printBoard(game);
    }
}
