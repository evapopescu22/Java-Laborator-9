package repo;

import java.util.List;

import javax.persistence.EntityManager;
import entity.Artist;
import util.PersistenceUtil;

public class ArtistRepository {

	public void create(Artist artist) {
		EntityManager em = null;
		try {
			em = PersistenceUtil.createEntityManager();
			em.getTransaction().begin();
			em.persist(artist);
			em.getTransaction().commit();
			System.out.println("Artist added");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	public static Artist findById(int id) {
		EntityManager em = null;
		try {

			em = PersistenceUtil.createEntityManager();
			em.getTransaction().begin();
			Artist artist = (Artist) em
					.createNativeQuery("SELECT a.id, a.name, a.country from Artists a WHERE a.id =" + id, Artist.class)
					.getSingleResult();
			System.out.println(artist);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return null;

	}

	public static List<Artist> findByName(String name) {
		EntityManager em = null;
		try {

			em = PersistenceUtil.createEntityManager();
			em.getTransaction().begin();
			List<Artist> album = (List<Artist>) em.createNamedQuery("findByName", Artist.class).setParameter(1, name)
					.getResultList();
			System.out.println(album);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return null;

	}
}
