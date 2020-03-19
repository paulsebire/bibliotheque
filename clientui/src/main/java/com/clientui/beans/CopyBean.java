package com.clientui.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;


public class CopyBean {
    private Long id;
    private String serialNumber;
    @JsonProperty("book")
    private BookBean book;
    @JsonProperty("reservation")
    private Collection<ReservationBean> reservation;

    public CopyBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BookBean getBook() {
        return book;
    }

    public void setBook(BookBean book) {
        this.book = book;
    }

    public Collection<ReservationBean> getReservation() {
        return reservation;
    }

    public void setReservation(Collection<ReservationBean> reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "CopyBean{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", book=" + book +
                ", reservation=" + reservation +
                '}';
    }
}
