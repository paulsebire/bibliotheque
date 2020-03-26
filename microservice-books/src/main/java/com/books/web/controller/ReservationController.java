package com.books.web.controller;


import com.books.dao.ReservationRepository;
import com.books.entities.Reservation;
import com.books.web.exceptions.ReservationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping(value = "/utilisateur/{id}/reservations/")
    public List<Reservation> reservationList(@PathVariable(value = "id")Long id){
        List<Reservation> reservations = reservationRepository.findAllByIdUtilisateur(id);
        if (reservations.isEmpty()) throw new ReservationNotFoundException("Aucune reservation n'est disponible");
        return reservations;
    }
}
