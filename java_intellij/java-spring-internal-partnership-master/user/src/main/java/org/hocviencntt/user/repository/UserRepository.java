package org.hocviencntt.user.repository;



import org.hocviencntt.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

//	public List<User> findByUserName(String userName);
}
