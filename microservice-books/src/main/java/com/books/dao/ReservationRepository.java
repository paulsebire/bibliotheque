package com.books.dao;



import com.books.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ReservationRepository extends JpaRepository<Reservation, Long> {


}
