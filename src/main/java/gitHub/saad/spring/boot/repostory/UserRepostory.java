package gitHub.saad.spring.boot.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import gitHub.saad.spring.boot.model.User;

@NoRepositoryBean
public interface UserRepostory<T extends User> extends CrudRepository<T, Long> {
	
	@Query("select u from #{#entityName} as u where u.name = ?1 ")
	public List<T> findByName(String name);
	
	@Query("select u from #{#entityName} as u where dtype = ?1 ")
	public List<T> findByDtype(String type);

}