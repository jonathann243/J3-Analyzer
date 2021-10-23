package Enums;

public enum OperatorEnum {
    PLUS("+"), MOINS("-"), MULTIPLY("*"), DIVISE("/");

    private String symbole;

    OperatorEnum(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return symbole;
    }
}