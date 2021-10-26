package Enums;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public enum KeyWordEnum {

    PROCEDURE("Procedure"), FIN_PROCEDURE("Fin_Procedure"), DECLARE("declare"), ENTIER("entier"), REEL("reel");

    private String str;

    KeyWordEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

}
