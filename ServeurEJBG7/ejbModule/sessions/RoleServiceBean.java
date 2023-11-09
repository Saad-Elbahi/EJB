package sessions;

import java.util.List;

import dao.RoleDao;
import entities.Role;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "hamou")
public class RoleServiceBean implements RoleDao {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void assignRolesToUser(int userId, List<String> roleNames) {
        User user = em.find(User.class, userId);
        if (user != null) {
            List<Role> roles = findRolesByName(roleNames);
            user.setRoles(roles);
            em.merge(user);
        } else {
            // Handle user not found error
        }
    }

    public List<Role> findRolesByName(List<String> roleNames) {
        Query query = em.createQuery("SELECT r FROM Role r WHERE r.name IN :roleNames");
        query.setParameter("roleNames", roleNames);
        return query.getResultList();
    }
}
