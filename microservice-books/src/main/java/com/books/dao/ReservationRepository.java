package com.books.dao;



import com.books.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

public List<Reservation> findAllByIdUtilisateur(long idUser);
}
