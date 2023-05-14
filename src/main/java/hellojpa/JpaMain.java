package hellojpa;

import org.hibernate.Hibernate;

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

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent parent1 = em.find(Parent.class, parent.getId());
            parent1.getChildList().remove(0);

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


//
//    Team teamA = new Team();
//            teamA.setName("teamA");
//                    em.persist(teamA);
//
//                    Team teamB = new Team();
//                    teamB.setName("teamB");
//                    em.persist(teamB);
//
//final Member member = new Member();
//        member.setUsername("kim");
//        member.setTeam(teamA);
//        em.persist(member);
//
//final Member member2 = new Member();
//        member2.setUsername("kim2");
//        member2.setTeam(teamB);
//        em.persist(member2);
//
//        em.flush();
//        em.clear();
//
//        Member member1 = em.find(Member.class, member.getId());
//
////            System.out.println("member1.getUsername() = " + member1.getTeam().getName());
//
////            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();