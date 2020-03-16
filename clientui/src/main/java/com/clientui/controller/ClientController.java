package com.clientui.controller;

import com.clientui.beans.BookBean;
import com.clientui.proxies.MicroserviceBooksProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


@Controller
public class ClientController {

    @Autowired
    private MicroserviceBooksProxy booksProxy;

    /*
    * Étape (1)
    * Opération qui récupère la liste des produits et on les affichent dans la page d'accueil.
    * Les produits sont récupérés grâce à ProduitsProxy
    * On fini par rentourner la page Accueil.html à laquelle on passe la liste d'objets "produits" récupérés.
    * */
    @RequestMapping("/")
    public String accueil(Model model){

        List<BookBean> livres =  booksProxy.bookList();

        model.addAttribute("livres", livres);

        return "Accueil";
    }

    /*
    * Étape (2)
    * Opération qui récupère les détails d'un produit
    * On passe l'objet "produit" récupéré et qui contient les détails en question à  FicheProduit.html
    * */
    @RequestMapping("/fiche-livre/{id}")
    public String ficheLivre(@PathVariable int id,  Model model){

        BookBean livre = booksProxy.recupererUnLivre(id);
        int nbCopies= booksProxy.nombreDeCopiesDispo(id);
        model.addAttribute("livre", livre);
        model.addAttribute("nbCopies",nbCopies);
        return "FicheLivre";
    }


}
