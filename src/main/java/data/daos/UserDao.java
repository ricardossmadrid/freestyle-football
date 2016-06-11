package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import data.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query("select token.user from Token token where token.value = ?1")
    public User findByTokenValue(String tokenValue);

    @Query("select user from User user where user.userName = ?1 or user.email = ?1")
    public User findByUsernameOrEmail(String id);
    
    public List<User> findByUserNameIgnoreCaseContaining(String userName);

}
