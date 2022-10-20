package hellojpa;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        final EntityManager em = emf.createEntityManager();

        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            final CriteriaBuilder cb = em.getCriteriaBuilder();
            final CriteriaQuery<Member> query = cb.createQuery(Member.class);

            final Root<Member> m = query.from(Member.class);

            CriteriaQuery<Member> cq = query.select(m);

            String username = "dsafas";
            if (username != null) {
                cq = cq.where(cb.equal(m.get("username"), "kim"));
            }

            final List<Member> resultList = em.createQuery(cq)
                    .getResultList();


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

}
