package views;

/**
 * @author Josue Lubaki
 * @version 1.0
 */
public class Menu {
    /**
     * Methode qui permet de lire le menu principal de l'Application
     */
    public static void showMenu() {
        System.out.println("\t\t\t╔═════════════════════╗");
        System.out.println("\t\t\t║    MENU PRINCIPAL   ║");
        System.out.println("\t\t\t╚═════════════════════╝");
        System.out.println("\tTous les fichiers se trouvent sur le path (\"src/TestsFiles\")"
                + "\n\t Entrer le numero correspondant au fichier à ouvrir");
        System.out.println("\t 1. Test [correct]");
        System.out.println("\t 2. Test [incorrect] (le type de la variable n'est pas correct)");
        System.out.println("\t 3. Test [incorrect] (contient des variables non declarées)");
        System.out.println("\t 4. Test [incorrect] (le nom de la procédure n'est pareille que celui de la fin)");
        System.out.println("\t 5. Test (Entrer le nom de votre fichier)");
        System.out.println("\t 0. Quitter");
    }

}
