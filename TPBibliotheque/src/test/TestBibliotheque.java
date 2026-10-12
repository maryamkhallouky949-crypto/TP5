
package test;

import java.util.Scanner;

import entities.Bibliotheque;
import entities.Document;
import entities.Livre;
import entities.Revue;
import entities.Dictionnaire;
import entities.Roman;
import entities.Manuel;

public class TestBibliotheque {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Donner le nombre de documents : ");
        int n = sc.nextInt();
        sc.nextLine();
        Bibliotheque b = new Bibliotheque(n);
        if (n >= 2) {
            b.ajouter(new Roman(
                "Le Petit Prince",
                "Antoine de Saint-Exupery",
                96,
                45.0
            ));

            b.ajouter(new Manuel(
                "Java pour debutants",
                "Ahmed",
                200,
                "Debutant"
            ));
        } else if (n == 1) {
            b.ajouter(new Roman(
                "Le Petit Prince",
                "Antoine de Saint-Exupery",
                96,
                45.0
            ));
        }

        // 4. Menu principal
        int choix;

        do {
            System.out.println("\n===== MENU BIBLIOTHEQUE =====");
            System.out.println("1. Afficher tous les documents");
            System.out.println("2. Ajouter un document");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher un document");
            System.out.println("5. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1:
                    b.afficherDocuments();
                    break;

                case 2:
                    System.out.println("Type de document :");
                    System.out.println("1. Livre");
                    System.out.println("2. Revue");
                    System.out.println("3. Dictionnaire");
                    System.out.println("4. Roman");
                    System.out.println("5. Manuel");
                    System.out.print("Votre choix : ");

                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Donner le titre : ");
                    String titre = sc.nextLine();

                    Document doc = null;

                    switch (type) {

                        case 1:
                            System.out.print("Donner l'auteur : ");
                            String auteurL = sc.nextLine();

                            System.out.print("Donner le nombre de pages : ");
                            int pagesL = sc.nextInt();
                            sc.nextLine();

                            doc = new Livre(titre, auteurL, pagesL);
                            break;

                        case 2:
                            System.out.print("Donner le mois : ");
                            String mois = sc.nextLine();

                            System.out.print("Donner l'annee : ");
                            int annee = sc.nextInt();
                            sc.nextLine();

                            doc = new Revue(titre, mois, annee);
                            break;

                        case 3:
                            System.out.print("Donner la langue : ");
                            String langue = sc.nextLine();

                            doc = new Dictionnaire(titre, langue);
                            break;

                        case 4:
                            System.out.print("Donner l'auteur : ");
                            String auteurR = sc.nextLine();

                            System.out.print("Donner le nombre de pages : ");
                            int pagesR = sc.nextInt();

                            System.out.print("Donner le prix : ");
                            double prix = sc.nextDouble();
                            sc.nextLine();

                            doc = new Roman(
                                titre, auteurR, pagesR, prix
                            );
                            break;

                        case 5:
                            System.out.print("Donner l'auteur : ");
                            String auteurM = sc.nextLine();

                            System.out.print("Donner le nombre de pages : ");
                            int pagesM = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Donner le niveau : ");
                            String niveau = sc.nextLine();

                            doc = new Manuel(
                                titre, auteurM, pagesM, niveau
                            );
                            break;

                        default:
                            System.out.println("Type invalide.");
                    }

                    if (doc != null) {
                        if (b.ajouter(doc)) {
                            System.out.println("Document ajoute avec succes.");
                        } else {
                            System.out.println("Bibliotheque pleine !");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Donner le numero du document a supprimer : ");
                    int numSup = sc.nextInt();
                    sc.nextLine();

                    Document aSupprimer = b.document(numSup);

                    if (aSupprimer != null && b.supprimer(aSupprimer)) {
                        System.out.println("Document supprime.");
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 4:
                    System.out.print("Donner le numero du document : ");
                    int numRecherche = sc.nextInt();
                    sc.nextLine();

                    Document resultat = b.document(numRecherche);

                    if (resultat != null) {
                        System.out.println(resultat);
                    } else {
                        System.out.println("Document introuvable.");
                    }
                    break;

                case 5:
                    b.afficherAuteurs();
                    break;

                case 0:
                    System.out.println("Fin du programme.");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        sc.close();
    }
}

