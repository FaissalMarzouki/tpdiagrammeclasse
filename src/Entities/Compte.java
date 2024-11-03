package Entities;

import java.util.*;

public class Compte {
    private int id;
    private String numero;
    private List<Operation> operations;
    private double soldeCourant;
    private Client client;

    public Compte(int id, String numero, Client client) {
        this.id = id;
        this.numero = numero;
        this.client = client;
        this.operations = new ArrayList<>();
        this.soldeCourant = 0;
    }

    public void ajouterOperation(Operation op) {
        operations.add(op);
        calculerSolde();
    }

    public void calculerSolde() {
        soldeCourant = 0;
        for(Operation op : operations) {
            if(op.getType().equals("virement")) {
                soldeCourant += op.getMontant();
            } else if(op.getType().equals("retrait")) {
                soldeCourant -= op.getMontant();
            }
        }
    }

    public void afficherDetail() {
        System.out.println("Client : " + client.getNom() + " " + client.getPrenom());
        System.out.println("Compte N°: " + numero);
        System.out.println("Opérations:");
        
        for(Operation op : operations) {
            System.out.println(op.getDate() + " " + op.getType() + " " + op.getMontant());
        }
        
        System.out.println("Solde: " + soldeCourant);
    }

    // Getters
    public String getNumero() { return numero; }
    public Client getClient() { return client; }
    public double getSoldeCourant() { return soldeCourant; }
}
