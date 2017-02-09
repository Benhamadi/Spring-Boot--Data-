package gitHub.saad.spring.boot.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import gitHub.saad.spring.boot.model.User;
import gitHub.saad.spring.boot.repostory.UserRepostory;


@Service
public class UserService {

	@Resource
	private UserRepostory<User> userRepostory;
	
	public List<User> findAllUsers() {
			
		return (List<User>) userRepostory.findAll() ;
	}
	public void addUsers(User user) {
		userRepostory.save(user);
	}
	public List<User> findByName(String name) {
		return  userRepostory.findByName(name);
	}
	
	public List<User> findByDtype(String type) {
		return  userRepostory.findByDtype(type);
	}
	public void removeUsers(Long id) {
		userRepostory.delete(id);
	}
	

}
