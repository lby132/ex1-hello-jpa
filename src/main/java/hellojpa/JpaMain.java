package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        final EntityManager em = emf.createEntityManager();

        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            final Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            final Member member = new Member();
            member.setUsername("hello");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            final Member m = em.find(Member.class, member.getId());

            System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());

            System.out.println("========");
            System.out.println("m.getTeam().getName() = " + m.getTeam().getName());
            System.out.println("========");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void printMemberAndTeam(Member member) {
        final String username = member.getUsername();
        System.out.println("username = " + username);

        final Team team = member.getTeam();
        System.out.println("team.getName() = " + team.getName());
    }
}
