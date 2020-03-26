package com.books.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Copy{
    @Id @GeneratedValue
    @Column(name = "id_copy")
    public Long id;

    public String serialNumber;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name ="id" )
    public Book book;

    @JsonIgnore
    @OneToMany(mappedBy = "copy",fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    public Collection<Reservation> reservations;

    public Copy() { super();}

    public Copy(String serialNumber, Book book) {
        this.serialNumber = serialNumber;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public Collection<Reservation> getReservation() {
        return reservations;
    }

    public void setReservation(Collection<Reservation> reservations) {
        this.reservations = reservations;
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
                ", reservations=" + reservations +
                '}';
    }
}
