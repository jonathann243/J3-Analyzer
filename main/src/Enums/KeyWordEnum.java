package Enums;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public enum KeyWordEnum {

    PROCEDURE("Procedure"), FIN_PROCEDURE("Fin_Procedure"), DECLARE("declare"), ENTIER("entier"), REEL("reel");

    private final String keyWord;

    KeyWordEnum(String str) {
        this.keyWord = str;
    }

    public String getKeyWord() {
        return keyWord;
    }

}
