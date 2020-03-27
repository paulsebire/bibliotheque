package com.books.web.controller;


import com.books.dao.CopiesRepository;
import com.books.dao.ReservationRepository;
import com.books.entities.Copy;
import com.books.entities.Reservation;
import com.books.poxies.MicroserviceUtilisateurProxy;
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
    @Autowired
    private CopiesRepository copiesRepository;


    @GetMapping(value = "/utilisateur/{id}/reservations/")
    public List<Reservation> reservationList(@PathVariable(value = "id")Long id){
        List<Reservation> reservations = reservationRepository.findAllByIdUtilisateurAndCloturerFalseOrderByIdAsc(id);
        if (reservations.isEmpty()) throw new ReservationNotFoundException("Aucune reservation n'est disponible");
        return reservations;
    }

    @PostMapping(value = "/utilisateur/{idUser}/reservations/{idResa}/prolonger")
    void prolongerReservation(@PathVariable(value = "idResa")Long idResa,@PathVariable(value = "idUser") Long idUser){
        Optional<Reservation> r= reservationRepository.findById(idResa);
        Date dateDujour = new Date();
        if (r.isPresent()){
            Reservation reservation=r.get();
            if (reservation.getIdUtilisateur()==idUser && reservation.isProlonger()==false
                    && reservation.getDateRetour().compareTo(dateDujour)>=0){
                reservation.setProlonger(true);
                reservation.setDateRetour(bibliService.ajouter4semaines(reservation.getDateRetour()));
                reservationRepository.save(reservation);
            } else throw new ReservationNotFoundException("operation impossible");
        } else throw new ReservationNotFoundException("La reservation n'est pas disponible");
    }

    @PostMapping(value = "/utilisateur/{idUser}/copie/{idCopy}/reserver")
     String reserverCopy(@PathVariable(value = "idUser")Long idUser,@PathVariable(value = "idCopy")Long idCopy){
        Copy copy= copiesRepository.findById(idCopy).get();

        if (copy!=null){
            if (copy.isDispo()){
                Reservation reservation=new Reservation(copy,new Date());
                reservation.setIdUtilisateur(idUser);
                copy.setDispo(false);
                copiesRepository.save(copy);
                reservationRepository.save(reservation);
                return "ok";
            }
        }return "Not ok";
    }

    @PostMapping(value = "/reservation/{idResa}/cloturer")
    String cloturerReservation(@PathVariable(value = "idResa")Long idResa){
        Reservation reservation= reservationRepository.findById(idResa).get();

        if (reservation!=null){
            if (!reservation.isCloturer()){
                Copy copy = copiesRepository.findById(reservation.getCopy().getId()).get();
                reservation.setCloturer(true);
                copy.setDispo(true);
                copiesRepository.save(copy);
                reservationRepository.save(reservation);
                return "ok";
            }
        }return "Not ok";
    }
}
