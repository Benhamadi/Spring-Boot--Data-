package gitHub.saad.spring.boot.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import gitHub.saad.spring.boot.model.Book;

public interface BookOwnRepository extends Repository<Book,Long>{
	@Query(value="select author from Book b1 where b1.author=?1")
	List<Book> findByName(String name);
	List<Book> findByNameAndAuthor(String name, String author);
}
