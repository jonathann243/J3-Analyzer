package Utilitaire;

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
     * 
     * @param message Le message à afficher à l'utilisateur
     * @return int
     */
    public static int getInputInt(String message) {
        System.out.print(message);
        System.out.print("\n\t $> ");
        return scanner.nextInt();
    }

    /* Copyright */
    public static void copyright() {
        System.out.println("╔═════════════════════════════════════════════════════════════╗");
        System.out.println("║ \tCopyright 2021 - Toute Reproduction Interdite ©       ║");
        System.out.println("║ @Authors : Josue Lubaki & Jonathan Kanyinda & Jordan Kuibia ║");
        System.out.println("╚═════════════════════════════════════════════════════════════╝");
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
