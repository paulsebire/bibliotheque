package com.clientui.proxies;

import com.clientui.beans.BookBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "zuul-server")
public interface MicroserviceBooksProxy {

    @GetMapping(value = "/microservice-books/livres")
    List<BookBean> bookList();

    /*
    * Notez ici la notation @PathVariable("id") qui est différente de celle qu'on utlise dans le contrôleur
    **/
    @GetMapping( value = "/microservice-books/livre/{id}")
    BookBean recupererUnLivre(@PathVariable("id") int id);


    @GetMapping(value = "/microservice-books/livre/{id}/copies")
    int nombreDeCopiesDispo(@PathVariable("id") int id);

}
