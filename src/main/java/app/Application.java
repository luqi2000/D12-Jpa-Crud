package app;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.annotations.common.util.impl.Log;
import dao.EventoDAO;
import entities.Evento;
import entities.TipoEvento;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	
	public static void main(String[] args) {
		log.info("benvenuto");
		
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