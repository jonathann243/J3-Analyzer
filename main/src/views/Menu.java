package views;

public class Menu {
    public static void showMenu() {
        System.out.println("\t\t\t╔═════════════════════╗");
        System.out.println("\t\t\t║    MENU PRINCIPAL   ║");
        System.out.println("\t\t\t╚═════════════════════╝");
        System.out.println("\tTous les fichiers se trouvent sur le path (\"src/TestsFiles\")"
                + "\n\t Entrer le numero correspondant au fichier à ouvrir");
        System.out.println("\t 1. Procédure calcule [correct]");
        System.out.println("\t 2. Procédure calcule [incorrect]");
        System.out.println("\t 0. Quitter");
    }

}
