package TicTacToe.Factory;

import TicTacToe.Models.BotDifficultyLevel;
import TicTacToe.Strategies.BotWinningStrategies.BotWinningStrategy;
import TicTacToe.Strategies.BotWinningStrategies.EasyWinningStrategy;
import TicTacToe.Strategies.BotWinningStrategies.HardWinningStrategy;
import TicTacToe.Strategies.BotWinningStrategies.MediumWinningStrategy;

public class BotPlayingStrategyFactory {

    public static BotWinningStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EasyWinningStrategy();
        }
        else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)){
            return new MediumWinningStrategy();
        }
        return new HardWinningStrategy();
    }
}
