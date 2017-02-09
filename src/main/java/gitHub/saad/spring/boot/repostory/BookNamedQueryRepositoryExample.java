package gitHub.saad.spring.boot.repostory;

import java.util.List;

import org.springframework.data.repository.Repository;

import gitHub.saad.spring.boot.model.Book;

public interface BookNamedQueryRepositoryExample extends Repository<Book, Long> {
	// Query will be used from Named query defined at Entity class
	List<Book> findByPrice(long price);
}
