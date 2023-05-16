package app;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dao.EventoDAO;
import entities.Evento;
import entities.TipoEvento;
import utils.JpaUtil;

public class Application {
	public static Logger logger = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	
	public static void main(String[] args) {
		logger.info("benvenuto");
		
		EntityManager em = emf.createEntityManager();
		
		EventoDAO ev = new EventoDAO(em);
		Evento uno = new Evento("Primo evento", LocalDate.now(),"Evento rock" , TipoEvento.privato, 20);
		Evento due = new Evento("Secondo evento", LocalDate.now(),"Evento piccolo" , TipoEvento.privato, 20);
		Evento tre = new Evento("Terzo evento", LocalDate.now(),"Evento grande" , TipoEvento.privato, 20);
		Evento quattro = new Evento("Quarto evento", LocalDate.now(),"Evento gigantesco" , TipoEvento.privato, 20);
		
		//ev.save(uno);
		//ev.save(due);
		//ev.save(tre);
		//ev.save(quattro);
		System.out.println(ev.getById(10));
		
		ev.FindAndDelete(11);
		ev.refresh(13);

		em.close();
		emf.close();
		
	}
}