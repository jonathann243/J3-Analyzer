package utilitaire;

import lexicalUnit.IdentificatorUnit;
import lexicalUnit.KeyWordUnit;
import lexicalUnit.OperatorUnit;
import lexicalUnit.SeparatorUnit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public class Utils {
    static Scanner scanner = new Scanner(System.in);
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN

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
        } while (!isDigit(response, true));
        return Integer.parseInt(response);
    }

    /**
     * Methode qui permet de récupérer l'input en char entré par l'utilisateur
     * N'accepte que le char (le caractère)
     *
     * @param message Le message à afficher à l'utilisateur
     * @return int
     */
    public static char getInputOnlyChar(String message) {
        char ch;
        do {
            System.out.print(message);
            ch =  scanner.nextLine().toLowerCase().charAt(0);
        } while (!isLetter(ch));
        return ch;
    }

    /**
     * Methode qui vérifie si chaque character de la chaine de caractère passé en
     * paramètre est un chiffre
     * 
     * @param str La chaine de caractère à vérifier
     * @param opt si true, on vérifie de manière stricte [0-9], sinon on vérifie s'il peut être entier ou reel
     * @return boolean
     */
    public static boolean isDigit(String str, boolean opt) {
        if(opt){
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        else{
            // regex pour vérifier si c'et un entier ou reel
            return str.matches("[0-9]{1,13}(\\.[0-9]+)?");
        }
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
        System.out.println(YELLOW_BOLD  + "\t╔═════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(YELLOW_BOLD  + "\t║ \t    Copyright 2021 - Toute Reproduction Interdite ©       ║" + RESET);
        System.out.println(YELLOW_BOLD  + "\t║ @Authors : Josue Lubaki & Jonathan Kanyinda & Jordan Kuibia ║" + RESET);
        System.out.println(YELLOW_BOLD  + "\t╚═════════════════════════════════════════════════════════════╝" + RESET);
        Utils.closeScanner();
    }

    /**
     * Methode qui permet d'ouvrir un fichier et lire toutes les lignes contenues
     * 
     * @param fileName Le nom du fichier à ouvrir
     * @return List<String>
     */
    public static List<String> readFile(String fileName) {
        String path = null;

        if(Character.isDigit(fileName.charAt(0))){
            path = "main/src/testsFiles/testFile" + fileName.charAt(0);
        }
        else if(Character.isLetter(fileName.charAt(0))){
            path = "main/src/testsFiles/" + fileName;
        }

        List<String> lines = new ArrayList<>();
        try {
            assert path != null;
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(YELLOW_BOLD_BRIGHT  + "ANALYSE LEXICALE : " + RESET + "Le fichier \""
                    + GREEN_BOLD + fileName + RESET + "\" est introuvable, assurez-vous de l'avoir placé dans le dossier " +
                    YELLOW_UNDERLINED  + "'./src/testsFiles/'" + RESET);
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
