package bi.guymichel.gufatisha_app.Models;

public class Hotel {
 public  String nom,image,wifi,resto,hour_work,climat,room_meet;
 public Hotel(String nom,String image,String wifi,String resto,String hour_work,String climat,String room_meet){
     this.nom = nom;
     this.image = image;
     this.wifi = wifi;
     this.resto = resto;
     this.hour_work = hour_work;
     this.climat = climat;
     this.room_meet = room_meet;
 }

    @Override
    public String toString() {
        return "Hotel{" +
                "nom='" + nom + '\'' +
                ", image='" + image + '\'' +
                ", wifi='" + wifi + '\'' +
                ", resto='" + resto + '\'' +
                ", hour_work='" + hour_work + '\'' +
                ", climat='" + climat + '\'' +
                ", room_meet='" + room_meet + '\'' +
                '}';
    }
}
