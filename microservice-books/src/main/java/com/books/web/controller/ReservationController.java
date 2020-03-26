package com.books.web.controller;


import com.books.dao.ReservationRepository;
import com.books.entities.Reservation;
import com.books.services.BibliServiceImpl;
import com.books.web.exceptions.ReservationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BibliServiceImpl bibliService;

    @GetMapping(value = "/utilisateur/{id}/reservations/")
    public List<Reservation> reservationList(@PathVariable(value = "id")Long id){
        List<Reservation> reservations = reservationRepository.findAllByIdUtilisateur(id);
        if (reservations.isEmpty()) throw new ReservationNotFoundException("Aucune reservation n'est disponible");
        return reservations;
    }

    @PostMapping(value = "/reservations/{id}/prolonger")
    void prolongerReservation(@PathVariable(value = "id")Long id, Long idUtilisateur){
        Optional<Reservation> r= reservationRepository.findById(id);
        Date dateDujour = new Date();
        if (r.isPresent()){
            Reservation reservation=r.get();
            if (reservation.getIdUtilisateur()==idUtilisateur && reservation.isProlonger()==false
                    && reservation.getDateRetour().compareTo(dateDujour)>=0){
                reservation.setProlonger(true);
                reservation.setDateRetour(bibliService.ajouter4semaines(reservation.getDateRetour()));
                reservationRepository.save(reservation);
            } else throw new ReservationNotFoundException("operation impossible");
        } else throw new ReservationNotFoundException("La reservation n'est pas disponible");
    }
}
