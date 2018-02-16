package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Artwork;



public class ArtworkHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ArtGallaryStevens");
	
	public void insertArtwork(Artwork toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	 public List<Artwork> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Artwork> allResults = em.createQuery("select aw from Artwork aw ", Artwork.class );
		List<Artwork> allArt = allResults.getResultList();
		em.close();
		return allArt;
	}

	
	 public void deleteArt(Artwork toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Artwork> typedQuery = em.createQuery("select aw from Artwork aw where aw.id = :selectedId", Artwork.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Artwork result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	 public Artwork searchForArtById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			Artwork foundArt = em.find(Artwork.class, idToEdit);
			em.close();
			return foundArt;
		}
	 public void updateArt(Artwork toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
			
		}

}
