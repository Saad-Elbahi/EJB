package dao;

import java.util.List;

import entities.Student;
import jakarta.ejb.Remote;

@Remote
public interface FiliereDao {
	   void assignFilierToStudent(int StudentId, int  filiereId);
	    List<Student> getStudentsInFiliere(int filiereId);
	   
}
