package com.ocr.projet7.projet7.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Reservation implements Serializable {
    @Id@GeneratedValue
    @Column(name = "id_reservation")
    private Long id;

    private Date dateEmprunt;
    private Date dateRetour;
    private boolean prolonger=false;

    @OneToOne
    @JoinColumn(name ="ID_COPY" )
    private Copy copy;

    @ManyToOne
    @JoinColumn(name ="id_user" )
    private Utilisateur utilisateur;

    public Reservation() {
        super();
    }

    public Reservation(Utilisateur utilisateur,Copy copy,Date dateEmprunt) {
        this.dateEmprunt=dateEmprunt;
        this.prolonger=false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public boolean isProlonger() {
        return prolonger;
    }

    public void setProlonger(boolean prolonger) {
        this.prolonger = prolonger;
    }


    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }
}
