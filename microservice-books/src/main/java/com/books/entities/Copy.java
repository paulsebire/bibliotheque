package com.books.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Copy{
    @Id @GeneratedValue
    @Column(name = "id_copy")
    private Long id;

    private String serialNumber;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name ="id" )
    private Book book;
    @JsonBackReference
    @OneToMany(mappedBy = "copy",fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Collection<Reservation> reservation;

    public Copy() { super();}

    public Copy(String serialNumber, Book book) {
        this.serialNumber = serialNumber;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public Collection<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(Collection<Reservation> reservation) {
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

    @Override
    public String toString() {
        return "Copy{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", book=" + book +
                ", reservation=" + reservation +
                '}';
    }
}
