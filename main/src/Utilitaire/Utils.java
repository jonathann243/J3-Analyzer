package Utilitaire;

import LexicalUnit.IdentificatorUnit;
import LexicalUnit.KeyWordUnit;
import LexicalUnit.OperatorUnit;
import LexicalUnit.SeparatorUnit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Methode qui permet de récupérer les inputs en chaine de caractère entrés par
     * l'utilisateur
     * 
     * @param message Le message à afficher à l'utilisateur
     * @return String
     */
    public static String getInput(String message) {
        System.out.print(message);
        System.out.print("\n\t $> ");
        return scanner.nextLine();
    }

    /**
     * Methode qui permet de récupérer les inputs en entier entrés par l'utilisateur
     * N'accepte que les entiers (chiffres)
     * 
     * @param message Le message à afficher à l'utilisateur
     * @return int
     */
    public static int getInputOnlyDigit(String message) {
        String response;
        do {
            System.out.print(message);
            System.out.print("\n\t $> ");
            response = scanner.nextLine();
        } while (!isDigit(response));
        return Integer.parseInt(response);
    }

    /**
     * Methode qui vérifie si chaque character de la chaine de caractère passé en
     * paramètre est un chiffre
     * 
     * @param str La chaine de caractère à vérifier
     * 
     * @return boolean
     */
    public static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Methode qui vérifie si le character passé en paramètre est un chiffre
     * @param ch character à vérifier
     * @return boolean
     */
    public static boolean isDigit(char ch){
        return Character.isDigit(ch);
    }

    /**
     * Methode qui vérifie si le character passé en paramètre est une lettre
     * @param ch character à vérifier
     * @return boolean
     */
    public static boolean isLetter(char ch){
        return Character.isLetter(ch);
    }



    /**
     * Methode qui vérifie si le character passé en paramètre est un opérateur
     * @param ch character à vérifier
     * @return boolean
     */
    public static boolean isOperator(char ch){
        return OperatorUnit.isOperator(ch);
    }

    /**
     * Methode qui vérifie si la chaine des caractères passée en paramètre est un mot clé
     * @param str chaine des caractères à vérifier
     * @return boolean
     */
    public static boolean isKeyWord(String str){
        return KeyWordUnit.isKeyWord(str);
    }

    /**
     * Methode qui vérifie si la chaine des caractères passée en paramètre est un identificator
     * @param str chaine des caractères à vérifier
     * @return boolean
     */
    public static boolean isIdentificator(String str){
        return IdentificatorUnit.isIdentificator(str);
    }

    /**
     * Methode qui vérifie si la chaine des caractères passée en paramètre contient un '_' underscore
     * @param str chaine des caractères à vérifier
     * @return boolean
     */
    public static boolean isContainsUndescore(String str){
        return IdentificatorUnit.containsUnderscore(str);
    }

    /**
     * Methode qui vérifie si le character passé en paramètre est un separator
     * @param ch character à vérifier
     * @return boolean
     */
    public static boolean isSeparator(char ch){
        return SeparatorUnit.isSeparator(ch);
    }

    /* Copyright */
    public static void copyright() {
        System.out.println("╔═════════════════════════════════════════════════════════════╗");
        System.out.println("║ \tCopyright 2021 - Toute Reproduction Interdite ©       ║");
        System.out.println("║ @Authors : Josue Lubaki & Jonathan Kanyinda & Jordan Kuibia ║");
        System.out.println("╚═════════════════════════════════════════════════════════════╝");
        System.exit(1);
    }

    /**
     * Methode qui permet d'ouvrir un fichier et lire toutes les lignes contenues
     * 
     * @param fileName Le nom du fichier à ouvrir
     * @return List<String>
     */
    public static List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Methode qui permet de close le scanner
     * 
     * @retun void
     */
    public static void closeScanner() {
        scanner.close();
    }
}
