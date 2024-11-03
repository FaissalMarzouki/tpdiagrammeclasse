package Entities;

import java.util.Date;

public class Operation {
    private Date date;
    private String type;
    private double montant;

    public Operation(Date date, String type, double montant) {
        this.date = date;
        this.type = type;
        this.montant = montant;
    }

    public Date getDate() { return date; }
    public String getType() { return type; }
    public double getMontant() { return montant; }
}
