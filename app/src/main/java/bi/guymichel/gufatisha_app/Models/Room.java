package bi.guymichel.gufatisha_app.Models;

public class Room {
    public String id, numero, nbres_personnes,type_chambre,prix,pic1,pic2,pic3,hotel;
    public Room(String id, String numero, String nbres_personnes, String prix, String pic1, String pic2, String pic3, String hotel, String type_chambre) {
        this.id = id;
        this.numero = numero;
        this.nbres_personnes = nbres_personnes;
        this.type_chambre = type_chambre;
        this.prix = prix;
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.hotel = hotel;
    }

    public String getNumero() {
        return numero;
    }

    public String getNbres_personnes() {
        return nbres_personnes;
    }

    public String getPrix() {
        return prix;
    }

    public String getPic1() {
        return pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public String getPic3() {
        return pic3;
    }
}
