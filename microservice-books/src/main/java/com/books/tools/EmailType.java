package com.books.tools;

public class EmailType {

     String email;
     String titre;
     String dateDeFinDuPret;

    public EmailType() { super();
    }

    public EmailType(String email, String titre, String dateDeFinDuPret) {
        this.email = email;
        this.titre = titre;
        this.dateDeFinDuPret = dateDeFinDuPret;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDateDeFinDuPret() {
        return dateDeFinDuPret;
    }

    public void setDateDeFinDuPret(String dateDeFinDuPret) {
        this.dateDeFinDuPret = dateDeFinDuPret;
    }
}
