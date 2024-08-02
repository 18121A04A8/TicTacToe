package TicTacToe.Strategies.BotWinningStrategies;

import TicTacToe.Models.*;

import java.util.List;

public class EasyWinningStrategy implements BotWinningStrategy{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> cells : board.getBoard()){
            for(Cell cell : cells){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(null,new Cell(cell.getRow(),cell.getColumn()));
                }
            }
        }
        return null;
    }
}
