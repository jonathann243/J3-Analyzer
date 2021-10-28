package views;

import static Utilitaire.Utils.*;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public class Menu {
    /**
     * Methode qui permet de lire le menu principal de l'Application
     */
    public static void showMenu() {
        System.out.println(YELLOW_BOLD + "\t\t\t╔═════════════════════╗" + RESET);
        System.out.println(YELLOW_BOLD + "\t\t\t║    MENU PRINCIPAL   ║" + RESET);
        System.out.println(YELLOW_BOLD + "\t\t\t╚═════════════════════╝" + RESET);
        System.out.println("\tTous les fichiers se trouvent sur le path (\"src/TestsFiles\")"
                + "\n\t Entrer le numero correspondant au fichier à ouvrir");
        System.out.println("\t 1. Test [correct]");
        System.out.println("\t 2. Test [incorrect] (le type de la variable n'est pas correct)");
        System.out.println("\t 3. Test [incorrect] (contient des variables non declarées)");
        System.out.println("\t 4. Test [incorrect] (le nom de la procédure n'est pareille que celui de la fin)");
        System.out.println("\t 5. Test [incorrect] (Manque symbole '=')");
        System.out.println("\t 6. Test [incorrect] (Fichier vide)");
        System.out.println("\t 7. Test [incorrect] (Une parenthèse fermante manquante)");
        System.out.println("\t 8. Test (Entrer le nom de votre fichier)");
        System.out.println("\t 0. " + RED_BOLD + "Quitter" + RESET);
    }

}
