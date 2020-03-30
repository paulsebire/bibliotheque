package com.clientui.controller;

import com.clientui.beans.BookBean;
import com.clientui.beans.CopyBean;
import com.clientui.beans.ReservationBean;
import com.clientui.beans.UtilisateurBean;
import com.clientui.proxies.MicroserviceBooksProxy;

import com.clientui.proxies.MicroserviceUtilisateurProxy;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;




@Controller
public class ClientController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MicroserviceBooksProxy booksProxy;
    @Autowired
    private MicroserviceUtilisateurProxy utilisateurProxy;

    /*
    * Étape (1)
    * Opération qui récupère la liste des produits et on les affichent dans la page d'accueil.
    * Les produits sont récupérés grâce à ProduitsProxy
    * On fini par rentourner la page Accueil.html à laquelle on passe la liste d'objets "produits" récupérés.
    * */
    @GetMapping("/")
    public String accueil(Model model,@RequestParam(name = "mc", defaultValue = "")String mc){
        List<BookBean> livres =  booksProxy.bookList(mc);
        model.addAttribute("livres", livres);
        model.addAttribute("mc",mc);
        log.info("Récupération de la liste des livres");
        return "Accueil";
    }


    /*
    * Étape (2)
    * Opération qui récupère les détails d'un produit
    * On passe l'objet "produit" récupéré et qui contient les détails en question à  FicheProduit.html
    * */
    @GetMapping("/fiche-livre/{id}")
    public String ficheLivre(@PathVariable Long id,  Model model){

        BookBean livre = booksProxy.recupererUnLivre(id);
        List<CopyBean> copies = booksProxy.CopiesDispo(id);
        System.out.println("copies"+copies);
        model.addAttribute("livre", livre);
        model.addAttribute("copies",copies);
        log.trace("Récupération de la fiche d'un livre");
        return "FicheLivre";
    }

    @GetMapping("/users")
    public String allUsers(Model model){
        List<UtilisateurBean> userList= utilisateurProxy.utilisateurList();
        model.addAttribute("userList",userList);
        return "users";
    }

    @GetMapping("/MonProfile")
    public String monProfile (Model model){
        UtilisateurBean utilisateur = (UtilisateurBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<ReservationBean> reservations = booksProxy.reservationList(utilisateur.getIdUser());
        model.addAttribute("reservations",reservations);
        return "MonProfile";
    }

    @GetMapping("/reservation/{id}/prolonger")
    public String prolongerResa(@PathVariable(value = "id")Long id){
        UtilisateurBean utilisateur = (UtilisateurBean) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user"+utilisateur);
        booksProxy.prolongerReservation(id,utilisateur.getIdUser());
        return "redirect:/MonProfile";
    }
}
