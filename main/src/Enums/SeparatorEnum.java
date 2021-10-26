package Enums;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public enum SeparatorEnum {
    SEMICOLON(';'), DOUBLEPOINT(':'), BRACKETOPEN('('), BRACKETCLOSE(')'), EQUALITY('=');

    private char separator;

    SeparatorEnum(char separator) {
        this.separator = separator;
    }

    public char getSeparator() {
        return separator;
    }
}
