package ptf.si.rs.zadaca5.repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class JPARepository<T> implements CRUDRepository<T> {
    private final EntityManager em;
    private final Class<T> clazz;

    public JPARepository(Class<T> clazz, EntityManager em) {
        this.em = em;
        this.clazz = clazz;
    }

    @Override
    public void save(T value) {
        em.getTransaction().begin();
        em.persist(value);
        em.getTransaction().commit();
    }

    @Override
    public void update(T value) {
        em.getTransaction().begin();
        em.merge(value);
        em.getTransaction().commit();
    }

    @Override
    public List<T> readAll() {
        CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(clazz);
        cq.select(cq.from(clazz));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void delete(Long id) {
        T value = em.find(clazz, id);
        if (value != null) {
            em.getTransaction().begin();
            em.remove(value);
            em.getTransaction().commit();
        }
    }
}
