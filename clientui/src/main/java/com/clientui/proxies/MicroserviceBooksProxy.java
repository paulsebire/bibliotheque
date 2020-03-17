package com.clientui.proxies;

import com.clientui.beans.BookBean;
import com.clientui.configuration.FeignConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "microserviceBooksProxy",configuration= FeignConfig.class)
@RibbonClient(name ="microservice-books")
@Component
public interface MicroserviceBooksProxy {

    @GetMapping(value = "/microservice-books/livres")
    List<BookBean> bookList();


    @GetMapping( value = "/microservice-books/livre/{id}")
    BookBean recupererUnLivre(@PathVariable("id") int id);


    @GetMapping(value = "/microservice-books/livre/{id}/copies")
    int nombreDeCopiesDispo(@PathVariable("id") int id);

}
