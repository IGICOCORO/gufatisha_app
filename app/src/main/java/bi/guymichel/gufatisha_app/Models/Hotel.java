package bi.guymichel.gufatisha_app.Models;

import java.util.ArrayList;

public class Hotel {
    public int id;
    public  String nom_hotel,image;
    public ArrayList<String> valeur = new ArrayList<>();

    public Hotel(int id, String nom_hotel, String image) {
        this.nom_hotel = nom_hotel;
        this.image = image;
        this.id = id;
    }

}
