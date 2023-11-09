package dao;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface RoleDao {
	   void assignRolesToUser(int userId, List<String> roleNames);
}
