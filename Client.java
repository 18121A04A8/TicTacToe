package TicTacToe;

import TicTacToe.Controllers.GameController;
import TicTacToe.Exceptions.InvalidBotCountException;
import TicTacToe.Exceptions.InvalidMoveException;
import TicTacToe.Exceptions.InvalidPlayerCountException;
import TicTacToe.Models.*;
import TicTacToe.Strategies.BotWinningStrategies.BotWinningStrategy;
import TicTacToe.Strategies.WinningStrategies.ColumnWinningStrategy;
import TicTacToe.Strategies.WinningStrategies.DiagonalWinningStrategy;
import TicTacToe.Strategies.WinningStrategies.RowWinningStrategy;
import TicTacToe.Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerCountException, InvalidMoveException {

        int dimension = 3;
        Player p1 = new Player("Mahi", new Symbol('*'), PlayerType.HUMAN);
        Bot p2 = new Bot("Anudeep", new Symbol('0'), BotDifficultyLevel.EASY);

        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();
        Game game = gameController.startGame(dimension, players, winningStrategies);
        while (game.getGameState().equals(GameState.IN_PROGRESS)){
            gameController.PrintBoard(game);
            gameController.makeMove(game);
        }
       if(game.getGameState().equals(GameState.ENDED)){
           gameController.PrintBoard(game);
           System.out.println("Winner is "+game.getWinner().getName());
       }
       else{
           gameController.PrintBoard(game);
           System.out.println("Game is Drawn");
       }


    }
}
