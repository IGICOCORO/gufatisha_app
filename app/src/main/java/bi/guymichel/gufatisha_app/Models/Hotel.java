package bi.guymichel.gufatisha_app.Models;

public class Hotel {
 public  String nom,image;
 public Hotel(String nom,String image){
     this.nom = nom;
     this.image = image;
 }

    @Override
    public String toString() {
        return "Hotel{" +
                "nom='" + nom + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public String getImage() {
        return image;
    }
}
