package TicTacToe.Models;

import TicTacToe.Factory.BotPlayingStrategyFactory;
import TicTacToe.Strategies.BotWinningStrategies.BotWinningStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotWinningStrategy botWinningStrategy;

    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel){
        super(name,symbol,PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botWinningStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotWinningStrategy getBotWinningStrategy() {
        return botWinningStrategy;
    }

    public void setBotWinningStrategy(BotWinningStrategy botWinningStrategy) {
        this.botWinningStrategy = botWinningStrategy;
    }

    @Override
    public Move makeMove(Board board){
        Move move = botWinningStrategy.makeMove(board);
        move.setPlayer(this);
        return move;

    }

}
