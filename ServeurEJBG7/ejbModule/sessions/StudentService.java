package sessions;

import java.util.List;

import dao.IDao;
import entities.Role;
import entities.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Stateless (name = "said")
public class StudentService implements IDao<Student> {
		
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Student create(Student o) {
		em.persist(o);
		return o ;
	}

	@Override
	public Student update(Student o) {
	    return em.merge(o);

		
	}

	@Override
	public boolean delete(Student o) {
		 Student studentToRemove = em.find(Student.class, o.getId());
		    if (studentToRemove != null) {
		        em.remove(studentToRemove);
		        return true; // Return true if the entity was successfully removed
		    }
		    return false; 
	}

	@Override
	public Student findById(int id) {
		 return em.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		Query query = em.createQuery("SELECT s from Student s");
		List<Student> students = query.getResultList();
		return students;

	}





}
