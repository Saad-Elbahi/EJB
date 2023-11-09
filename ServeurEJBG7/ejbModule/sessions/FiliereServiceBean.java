package sessions;

import java.util.List;

import dao.FiliereDao;
import entities.Filiere;
import entities.Student;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "hamouda")
public class FiliereServiceBean implements FiliereDao {
    @PersistenceContext
    private EntityManager em;
    
   
   

	@Override
	public void assignFilierToStudent(int StudentId, int filiereId) {
		  Student st = em.find(Student.class, StudentId);
	        if (st != null) {
	            Filiere filiere = em.find(Filiere.class, filiereId);
	            st.setFiliere(filiere);;
	            em.merge(st);
	        } else {
	            // Handle user not found error
	        }
		
	}




	@Override
	public List<Student> getStudentsInFiliere(int filiereId) {
		Query query = em.createQuery("SELECT NEW entities.Student( s.login, s.password, s.firstname, s.lastname, s.telephone) FROM Student s WHERE s.filiere.id = :filiereId", Student.class);
		query.setParameter("filiereId", filiereId);
		List<Student> students = query.getResultList();
		return students;
	

	}
}
