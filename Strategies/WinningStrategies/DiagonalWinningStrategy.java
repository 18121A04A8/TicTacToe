package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cell;
import TicTacToe.Models.Move;
import TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{

    private Map<Symbol, Integer> leftDiag = new HashMap<>();
    private  Map<Symbol, Integer> rightDiag = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {

        Cell cell = move.getCell();
        int row = cell.getRow();
        int col = cell.getColumn();
        Symbol symbol = move.getPlayer().getSymbol();
        int count = 0;
        if(row == col){
            if(!leftDiag.containsKey(symbol)){
                leftDiag.put(symbol,0);
            }
            leftDiag.put(symbol,leftDiag.get(symbol)+1);
            count = leftDiag.get(symbol);
            if(count == board.getDimension()){
                return true;
            }
        }

        if(row+col == board.getDimension()-1){
            if(!rightDiag.containsKey(symbol)){
                rightDiag.put(symbol,0);
            }
            rightDiag.put(symbol,rightDiag.get(symbol)+1);
            count = rightDiag.get(symbol);
            if(count == board.getDimension()){
                return true;
            }
        }

        return  false;
    }
}
