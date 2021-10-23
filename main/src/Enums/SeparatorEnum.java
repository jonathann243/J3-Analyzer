package Enums;

public enum SeparatorEnum {
    SEMICOLON(";"), DOUBLEPOINT(":"), BRACKETOPEN("("), BRACKETCLOSE(")"), EQUALITY("=");

    private String separator;

    SeparatorEnum(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
