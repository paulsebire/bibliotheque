package com.clientui.proxies;

import com.clientui.beans.BookBean;
import com.clientui.beans.ReservationBean;
import com.clientui.configuration.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "microserviceBooksProxy",
            configuration= FeignConfig.class)
@Component
public interface MicroserviceBooksProxy {

    @GetMapping(value = "/microservice-books/livres")
    List<BookBean> bookList(@RequestParam(name = "mc", defaultValue = "")String mc);

    @GetMapping( value = "/microservice-books/livre/{id}")
    BookBean recupererUnLivre(@PathVariable("id") Long id);

    @GetMapping(value = "/microservice-books/livre/{id}/copies")
    List CopiesDispo(@PathVariable("id") Long id);

    @GetMapping(value = "/microservice-books/utilisateur/{id}/reservations/")
    List<ReservationBean> reservationList(@PathVariable(value = "id")Long id);

    @PostMapping(value = "/microservice-books/utilisateur/{idUser}/reservations/{idResa}/prolonger")
    void prolongerReservation(@PathVariable(value = "idResa")Long idResa,@PathVariable(value = "idUser") Long idUser);
}
