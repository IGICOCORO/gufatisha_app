package bi.guymichel.gufatisha_app.Models;

public class Reservation {
    public String date_arrivee,date_depart,client,prix_chambre, numero_chambre;

    public Reservation( String numero_chambre,String client,String date_arrivee, String date_depart,String prix_chambre) {
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.client = client;
        this.numero_chambre = numero_chambre;
        this.prix_chambre = prix_chambre;
    }

    public String getDate_arrivee() {
        return date_arrivee;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public String getClient() {
        return client;
    }

    public String getPrix_chambre() {
        return prix_chambre;
    }

    public String getNumero_chambre() {
        return numero_chambre;
    }
}
