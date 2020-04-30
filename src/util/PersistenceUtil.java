package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

	private static EntityManagerFactory emf = null;

	public static EntityManager createEntityManager() {
		try {
			if (emf == null) {
				emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
				System.out.println("Connected");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return emf.createEntityManager();
	}
	
	
}

