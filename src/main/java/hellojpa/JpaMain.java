package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        final EntityManager em = emf.createEntityManager();

        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            final Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            System.out.println("team.getName() = " + team.getName());

            final Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            final Member findMember = em.find(Member.class, member.getId());

            final Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
