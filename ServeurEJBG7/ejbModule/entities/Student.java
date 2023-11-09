package entities;

import java.io.Serializable;

import jakarta.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student extends User implements Serializable {

	
	private String firstname;
	private String lastname;
	private Integer telephone;
	@ManyToOne
	private Filiere filiere;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}  
	
	public Student(String  login ,String password,  String firstname, String lastname, Integer telephone) {
		super(login,password);
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
	
	}
	
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}   
	public Integer getTelephone() {
		return this.telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}   
	public Filiere getFiliere() {
		return this.filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", telephone=" + telephone + ", filiere="
				+ filiere + ", getId()=" + getId() + ", getLogin()=" + getLogin() + ", getPassword()=" + getPassword()
				+ "]";
	}


   
}
