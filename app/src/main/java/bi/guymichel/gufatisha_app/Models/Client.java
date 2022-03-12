package bi.guymichel.gufatisha_app.Models;

public class Client {
    public  String nom,prenom,provenance,phone,email;

    public Client(String nom, String prenom, String provenance, String phone, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.provenance = provenance;
        this.phone = phone;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getProvenance() {
        return provenance;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
