package repo;

import java.util.List;
import javax.persistence.EntityManager;
import entity.Album;
import util.PersistenceUtil;

public class AlbumRepository {

	public void create(Album album) {
		EntityManager em = null;
		try {
			em = PersistenceUtil.createEntityManager();
			em.getTransaction().begin();
			em.persist(album);
			em.getTransaction().commit();
			System.out.println("Album added");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	public static Album findById(int id) {
		EntityManager em = null;
		try {

			em = PersistenceUtil.createEntityManager();
			em.getTransaction().begin();
			Album album = (Album) em.createNativeQuery("SELECT * from Albums where id =" + id, Album.class)
					.getSingleResult();
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

	public static List<Album> findByName(String name) {
		EntityManager em = null;
		try {

			em = PersistenceUtil.createEntityManager();
			em.getTransaction().begin();
			List<Album> album = (List<Album>) em.createNamedQuery("findByName1", Album.class).
					setParameter(1, name)
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
	
	public static List<Album> findByArtist(String name) {
		EntityManager em = null;
		try {

			em = PersistenceUtil.createEntityManager();
			em.getTransaction().begin();
			List<Album> album = (List<Album>) em.createNamedQuery("findByArtist", Album.class).
					setParameter(1, name)
					.getResultList();
			System.out.println(name +"'s"+" "+album);

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
