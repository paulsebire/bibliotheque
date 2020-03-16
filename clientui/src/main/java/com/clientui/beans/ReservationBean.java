package com.clientui.beans;

import java.util.Collection;
import java.util.Date;


public class ReservationBean {
    private Long id;
    private Date dateEmprunt;
    private Date dateRetour;
    private boolean prolonger=false;
    private CopyBean copy;

    public ReservationBean() {
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

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public boolean isProlonger() {
        return prolonger;
    }

    public void setProlonger(boolean prolonger) {
        this.prolonger = prolonger;
    }

    public CopyBean getCopy() {
        return copy;
    }

    public void setCopy(CopyBean copy) {
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "ReservationBean{" +
                "id=" + id +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRetour=" + dateRetour +
                ", prolonger=" + prolonger +
                ", copy=" + copy +
                '}';
    }
}