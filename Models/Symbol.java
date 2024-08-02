package TicTacToe.Models;

public class Symbol {
    private char aChar;
    private String imageUrl;

    public Symbol(char aChar) {
        this.aChar = aChar;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
