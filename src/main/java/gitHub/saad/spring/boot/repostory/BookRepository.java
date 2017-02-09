package gitHub.saad.spring.boot.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gitHub.saad.spring.boot.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

	List<Book> findByName(String name);
}
