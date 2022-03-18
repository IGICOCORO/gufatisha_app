package bi.guymichel.gufatisha_app.Models;

public class Reservation {
    public String date_arrivee,date_depart,client,chambre,prix;

    public Reservation(String date_arrivee, String date_depart, String client, String chambre,String prix) {
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.client = client;
        this.chambre = chambre;
        this.prix = prix;
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

    public String getChambre() {
        return chambre;
    }

    public String getPrix() {
        return prix;
    }
}
