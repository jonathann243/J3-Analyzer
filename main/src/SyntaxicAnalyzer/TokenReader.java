package SyntaxicAnalyzer;

import java.util.List;
import LexicalAnalyzer.Token;

public class TokenReader {

    private final List<Token> tokens;
    private int cursor;
    private boolean eol;

    public TokenReader(List<Token> tokens) {
        this.tokens = tokens;
        cursor = 0;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public boolean isEol() {
        return eol;
    }

    public Token getCurrentToken() {
        if(isEndOfTokenList() || tokens.size() <= 0 || cursor < 0){
            eol = true;
            return null;
        }
        return tokens.get(cursor);
    }

    // Methode moveCursorForward
    public void moveCursorForward() {
        if (isEndOfTokenList()) {
            eol = true;
        } else {
            cursor++;
        }
    }

    // methode moveCursorBack
    public void moveCursorBack() {
        if(cursor <= 0){
            return;
        }

        cursor--;
    }

    public Token nextToken() {
        ++cursor;

        if(isEndOfTokenList()){
            eol = true;
            return null;
        }

        return tokens.get(cursor);
    }

    public Token previousToken() {
        if(cursor < 0)
            return null;
        return tokens.get(--cursor);
    }

    /**
     * Méthode qui permet de savoir si on est à la fin de la ligne
     *
     * @return boolean - true si on est à la fin de la ligne, false sinon
     */
    public boolean isEndOfTokenList() {
        return cursor >= tokens.size();
    }

}
