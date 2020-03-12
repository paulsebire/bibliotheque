package com.books.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Copy implements Serializable {
    @Id @GeneratedValue
    @Column(name = "id_copy")
    private Long id;

    private String serialNumber;

    @ManyToOne
    @JoinColumn(name ="id" )
    private Book book;

    @OneToOne
    @JoinColumn(name ="ID_RESERVATION" )
    private Reservation reservation;

    public Copy() { super();}

    public Copy(String serialNumber, Book book) {
        this.serialNumber = serialNumber;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
