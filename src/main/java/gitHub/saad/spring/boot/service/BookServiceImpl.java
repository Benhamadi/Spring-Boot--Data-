package gitHub.saad.spring.boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gitHub.saad.spring.boot.model.Book;
import gitHub.saad.spring.boot.repostory.BookNamedQueryRepositoryExample;
import gitHub.saad.spring.boot.repostory.BookOwnRepository;
import gitHub.saad.spring.boot.repostory.BookQueryRepositoryExample;
import gitHub.saad.spring.boot.repostory.BookRepository;

@Service
public class BookServiceImpl  {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookOwnRepository bookOwnRepository;
	@Autowired
	private BookQueryRepositoryExample bookQueryRepository;
	@Autowired
	private BookNamedQueryRepositoryExample bookNamedQueryRepository;	

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public List<Book> findByName(String name) {
		System.out.println("bookQueryRepository"+bookQueryRepository.findByName(name));
		System.out.println("bookRepository"+bookRepository.findByName(name));
		System.out.println("bookOwnRepository"+bookOwnRepository.findByName(name));
		return bookQueryRepository.findByName(name);
	}

	public List<Book> findByNameMatch(String name) {
		return bookQueryRepository.findByNameMatch(name);
	}

	public List<Book> findByNamedParam(String name, String author, long price) {
		return bookQueryRepository.findByNamedParam(name, author, price);
	}

	public List<Book> findByPriceRange(long price1, long price2) {
		return bookQueryRepository.findByPriceRange(price1, price2);
	}

	public List<Book> findByPrice(long price) {
		return bookNamedQueryRepository.findByPrice(price);
	}

	public List<Book> findByNameAndAuthor(String name, String author) {
		return bookOwnRepository.findByNameAndAuthor(name, author);
	}

	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	public Book findOne(long id) {
		System.out.println("Cached Pages");
		return bookRepository.findOne(id);
	}

	public void delete(long id) {
		bookRepository.delete(id);
	}

	@Transactional
	public void removeAll() {
		bookRepository.deleteAllInBatch();
	}
}
