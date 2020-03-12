package com.books;

import com.books.dao.BookRepository;
import com.books.dao.CopiesRepository;
import com.books.dao.ReservationRepository;
import com.books.entities.Book;
import com.books.entities.Copy;
import com.books.entities.Reservation;
import com.books.services.BibliServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
public class MBooksApplication {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private BibliServiceImpl bibliService;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CopiesRepository copiesRepository;

	public static void main(String[] args) {
		SpringApplication.run(MBooksApplication.class, args);
	}


	@PostConstruct
	private void postConstruct() {
		if (reservationRepository.findAll().isEmpty()) {

			Book book1 = new Book("Le petit prince", "Antoine de Saint-Exupéry",
					"https://images-na.ssl-images-amazon.com/images/I/51WZzUKfHnL._SX330_BO1,204,203,200_.jpg");
			bookRepository.save(book1);

			Book book2 = new Book("Le chat botté", "Charles Perrault",
					"https://images-na.ssl-images-amazon.com/images/I/513GI6j3dIL._SX360_BO1,204,203,200_.jpg");
			bookRepository.save(book2);

			Book book3 = new Book("Les contes de Grimm", "Jacob et Wilhelm Grimm",
					"https://images-na.ssl-images-amazon.com/images/I/51QtHScO4zL._SX258_BO1,204,203,200_.jpg");
			bookRepository.save(book3);

			Book book4 = new Book("Le capital", "Karl Marx",
					"https://images-na.ssl-images-amazon.com/images/I/51gxl55u98L._SX306_BO1,204,203,200_.jpg");
			bookRepository.save(book4);

			Book book5 = new Book("1984", "George Orwell",
					"https://images-na.ssl-images-amazon.com/images/I/91SZSW8qSsL.jpg");
			bookRepository.save(book5);

			Book book6 = new Book("Le meilleur des mondes", "Aldous Huxley",
					"https://images-na.ssl-images-amazon.com/images/I/41C-TnHVegL._SX303_BO1,204,203,200_.jpg");
			bookRepository.save(book6);


			Copy copy1 = new Copy("SN001", book1);
			copiesRepository.save(copy1);
			Copy copy2 = new Copy("SN002", book1);
			copiesRepository.save(copy2);
			Copy copy3 = new Copy("SN003", book1);
			copiesRepository.save(copy3);

			Copy copy4 = new Copy("SN001", book2);
			copiesRepository.save(copy4);
			Copy copy5 = new Copy("SN002", book2);
			copiesRepository.save(copy5);
			Copy copy6 = new Copy("SN003", book2);
			copiesRepository.save(copy6);

			Copy copy7 = new Copy("SN001", book3);
			copiesRepository.save(copy7);
			Copy copy8 = new Copy("SN002", book3);
			copiesRepository.save(copy8);
			Copy copy9 = new Copy("SN003", book3);
			copiesRepository.save(copy9);

			Copy copy10 = new Copy("SN001", book4);
			copiesRepository.save(copy10);
			Copy copy11 = new Copy("SN002", book4);
			copiesRepository.save(copy11);
			Copy copy12 = new Copy("SN003", book4);
			copiesRepository.save(copy12);

			Copy copy13 = new Copy("SN001", book5);
			copiesRepository.save(copy13);
			Copy copy14 = new Copy("SN002", book5);
			copiesRepository.save(copy14);
			Copy copy15 = new Copy("SN003", book5);
			copiesRepository.save(copy15);

			Copy copy16 = new Copy("SN001", book6);
			copiesRepository.save(copy16);
			Copy copy17 = new Copy("SN002", book6);
			copiesRepository.save(copy17);
			Copy copy18 = new Copy("SN003", book6);
			copiesRepository.save(copy18);

			Reservation resa1 = new Reservation(copy1, new Date());
			resa1.setDateRetour(bibliService.ajouter4semaines(resa1.getDateEmprunt()));
			reservationRepository.save(resa1);

			Reservation resa2 = new Reservation(copy8, new Date());
			resa1.setDateRetour(bibliService.ajouter4semaines(resa2.getDateEmprunt()));
			reservationRepository.save(resa2);

			Reservation resa3 = new Reservation(copy10, new Date());
			resa1.setDateRetour(bibliService.ajouter4semaines(resa3.getDateEmprunt()));
			reservationRepository.save(resa3);

			Reservation resa4 = new Reservation(copy14, new Date());
			resa1.setDateRetour(bibliService.ajouter4semaines(resa4.getDateEmprunt()));
			reservationRepository.save(resa4);

			Reservation resa5 = new Reservation(copy18, new Date());
			resa1.setDateRetour(bibliService.ajouter4semaines(resa5.getDateEmprunt()));
			reservationRepository.save(resa5);


		}
	}
	}
