import java.util.Scanner;

import Entities.*;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Entrer les informations du client:");
        System.out.print("ID: ");
        int idClient = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        
        Client client = new Client(idClient, nom, prenom);
        
        System.out.println("\nEntrer les informations du compte:");
        System.out.print("ID du compte: ");
        int idCompte = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Numéro du compte: ");
        String numero = scanner.nextLine();
        
        Compte compte = new Compte(idCompte, numero, client);
        
        String reponse;
        do {
            System.out.println("\nVoulez-vous effectuer une opération? (oui/non)");
            reponse = scanner.nextLine();
            
            if (reponse.equalsIgnoreCase("oui")) {
                System.out.print("Type d'opération (virement/retrait): ");
                String type = scanner.nextLine();
                
                System.out.print("Montant: ");
                double montant = scanner.nextDouble();
                scanner.nextLine(); // vider le buffer
                
                compte.ajouterOperation(new Operation(new Date(), type, montant));
            }
        } while (reponse.equalsIgnoreCase("oui"));
        
        // Afficher le détail du compte
        System.out.println("\nDétails du compte:");
        compte.afficherDetail();
        
        scanner.close();
    }
}