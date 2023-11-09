package sessions;

import java.util.List;

import dao.IDao;
import entities.Filiere;
import entities.Role;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "hassan")
public class FiliereService implements IDao<Filiere> {

	@PersistenceContext
	private EntityManager em;
	
	


	@Override
	public List<Filiere> findAll() {
		Query query = em.createQuery("select u from Filiere  u");
		return query.getResultList();
	}

	@Override
	public Filiere create(Filiere o) {
		em.persist(o);
		return o;
	}

	@Override
	public Filiere update(Filiere o) {
	  em.merge(o);
	  return o;
	}
	@Override
	public boolean delete(Filiere o) {
	  em.remove(o);
	  return true;
	}
	@Override
	public Filiere findById(int id) {
Query query = em.createQuery("select u from Filiere  u where u.id:=id");
		
		return (Filiere) query.getSingleResult();
	}




	

}
