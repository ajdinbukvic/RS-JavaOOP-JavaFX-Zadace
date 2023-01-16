package ptf.si.rs.zadaca5;

import ptf.si.rs.zadaca5.models.Ticket;
import ptf.si.rs.zadaca5.repository.CRUDRepository;
import ptf.si.rs.zadaca5.repository.JPARepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Config {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private static final EntityManager em = emf.createEntityManager();
    public static final CRUDRepository<Ticket> tickets = new JPARepository<>(Ticket.class, em);
}
