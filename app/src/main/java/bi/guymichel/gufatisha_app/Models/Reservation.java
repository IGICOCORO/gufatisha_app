package bi.guymichel.gufatisha_app.Models;

import java.util.Date;

import bi.guymichel.gufatisha_app.Host;

public class Reservation {
    public String id,client,prix_chambre, numero_chambre;
    public Date date_depart, date_arrivee;

    public Reservation( String id,String numero_chambre,String client,String date_arrivee, String date_depart,String prix_chambre) {
        this.id = id;
        this.date_arrivee = Host.getDate(date_arrivee);
        this.date_depart = Host.getDate(date_depart);
        this.client = client;
        this.numero_chambre = numero_chambre;
        this.prix_chambre = prix_chambre;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", client='" + client + '\'' +
                ", prix_chambre='" + prix_chambre + '\'' +
                ", numero_chambre='" + numero_chambre + '\'' +
                ", date_depart=" + date_depart +
                ", date_arrivee=" + date_arrivee +
                '}';
    }

    public String getId() {
        return id;
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

    public Date getDate_depart() {
        return date_depart;
    }

    public Date getDate_arrivee() {
        return date_arrivee;
    }
}
