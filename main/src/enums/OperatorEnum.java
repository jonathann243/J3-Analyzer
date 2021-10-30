package enums;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public enum OperatorEnum {
    PLUS('+'), MOINS('-'), MULTIPLY('*'), DIVISE('/');

    private char symbole;

    OperatorEnum(char symbole) {
        this.symbole = symbole;
    }

    public char getSymbole() {
        return symbole;
    }
}
