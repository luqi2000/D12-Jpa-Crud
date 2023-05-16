package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entities.Evento;

public class EventoDAO {
	private final EntityManager em;
	
	public EventoDAO(EntityManager em) {
		this.em = em;
	}
	
	//metodo save
	public void save(Evento n) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();//partono le operazioni che voglio fare nel database
		em.persist(n);//salvera nel database cio che passo
		transaction.commit();//termina la transazione ed effettua il flush del oggetto
		System.out.println("Evento salvato");
	}
	
	//metodo getByid
	public Evento getById(long id) {
		Evento found = em.find(Evento.class, id);
		return found;
	}
	
	//metodo delete
	public void FindAndDelete(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Evento con id " + id + " eliminato!");
		}else {
			System.out.println("id non trovato");
		}
	}
	
	//metodo refresh
	
	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);
		found.setNumeroMassimoPartecipanti(25);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}
	
}
