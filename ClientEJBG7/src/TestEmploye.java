import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import dao.RoleDao;
import entities.Filiere;
import entities.Role;
import entities.Student;
import sessions.RoleService;

public class TestEmploye {


	public static IDao<Role> lookUpRoleRemote() throws NamingException {

		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Role>) context.lookup("ejb:/ServeurEJBG7/ali!dao.IDao");

	}
	public static IDao<Student> lookUpStudentRemote() throws NamingException {

		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Student>) context.lookup("ejb:/ServeurEJBG7/said!dao.IDao");

	}
	
	public static IDao<Filiere> lookUpFiliereRemote() throws NamingException {

		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Filiere>) context.lookup("ejb:/ServeurEJBG7/hassan!dao.IDao");

	}
	public static RoleDao lookUpRoledRemote() throws NamingException {

		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (RoleDao) context.lookup("ejb:/ServeurEJBG7/hamou!dao.RoleDao");

	}


	
	public static void main(String[] args) {
	    try {
	        
	        IDao<Role> daor = lookUpRoleRemote();
	        IDao <Student> das = lookUpStudentRemote();
	        RoleDao rola = lookUpRoledRemote();

	        
            List<String> roleNames = Arrays.asList("admin");

	        rola.assignRolesToUser(2, roleNames);
	       IDao <Filiere> dor = lookUpFiliereRemote();
	  //     dor.create(new Filiere("iir5", "mat"));
	    //   das.create(new Student("saad", "saad2001", "saadel", "elbahi", 5623516) );
	       
	       for(Student s: das.findAll()) {
	    	   System.out.println(s);
	       }

	    } catch (NamingException e) {
	        // Handle NamingException
	        e.printStackTrace();
	    } catch (Exception e) {
	        // Handle other exceptions
	        e.printStackTrace();
	    }
	}


}
