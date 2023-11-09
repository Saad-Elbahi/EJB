package sessions;

import java.util.List;

import dao.IDao;
import entities.Role;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless (name = "ali")
public class RoleService implements IDao<Role> {

	@PersistenceContext
	private EntityManager em;
	
	


	@Override
	public List<Role> findAll() {
		Query query = em.createQuery("select u from Role  u");
		return query.getResultList();
	}

	@Override
	public Role create(Role o) {
		em.persist(o);
		return o;
	}

	@Override
	public Role update(Role o) {
	em.merge(o);
	return o ;
	}

	@Override
	public boolean delete(Role o) {
	em.remove(o);
	return true;
	}

	@Override
	public Role findById(int id) {
	    Query query = em.createQuery("select r from Role r where r.id = :id");
	    query.setParameter("id", id);
	    return (Role) query.getSingleResult();
	}
//	@Override
//    public void assignRolesToUser(int userId, List<String> roleNames) {
//        User user = em.find(User.class, userId);
//        if (user != null) {
//            List<Role> roles = em.createQuery("SELECT r FROM Role r WHERE r.name IN :roleNames", Role.class)
//                                .setParameter("roleNames", roleNames)
//                                .getResultList();
//            user.setRoles(roles);
//            em.merge(user);
//        } else {
//            // Handle user not found error
//        }
//    }

	

}