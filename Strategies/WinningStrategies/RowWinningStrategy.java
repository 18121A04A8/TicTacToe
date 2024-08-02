package TicTacToe.Strategies.WinningStrategies;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Symbol;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{


    HashMap<Integer, HashMap<Symbol,Integer>> rowHashMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {


        int row =move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!rowHashMaps.containsKey(row)) {
            rowHashMaps.put(row, new HashMap<Symbol, Integer>());
        }
        HashMap<Symbol,Integer> hm = rowHashMaps.get(row);
        if(!hm.containsKey(symbol)){
            hm.put(symbol,0);
        }
        hm.put(symbol,hm.get(symbol)+1);
        int count = hm.get(symbol);

        return count == board.getDimension();

    }
}
