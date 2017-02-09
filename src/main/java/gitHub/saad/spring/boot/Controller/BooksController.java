package gitHub.saad.spring.boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gitHub.saad.spring.boot.model.Book;
import gitHub.saad.spring.boot.service.BookServiceImpl;

@RestController
@RequestMapping(value = "/books")
public class BooksController {
	@Autowired
	private BookServiceImpl bookService;

	@RequestMapping(value = "/add/{id}/{name}/{author}/{price}")
	public Book addBook(@PathVariable int id, @PathVariable String name, @PathVariable String author,
			@PathVariable long price) {
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		bookService.saveBook(book);
		return book;
	}

	@RequestMapping(value = "/add/books")
	public Book addBooks() {
		for(int i=0;i<15;i++){
			Book book = new Book();
			book.setName("learn");
			book.setAuthor("s");
			book.setPrice(300);
			bookService.saveBook(book);
		}
		
		return new Book();
	}
	@RequestMapping(value = "/delete/{id}")
	public void deleteBook(@PathVariable int id) {
		Book book = new Book();
		book.setId(id);
		bookService.delete(id);
	}
	@RequestMapping(value = "/")
	public List<Book> getBooks() {
		return bookService.findAll();
	}
	@RequestMapping(value = "/{id}")
	public Book getBook(@PathVariable int id) {
		Book book = bookService.findOne(id);
		return book;
	}
	@RequestMapping(value = "/search/name/{name}")
	public List<Book> getBookByName(@PathVariable String name) {
		List<Book> books = bookService.findByName(name);
		return books;
	}
	@RequestMapping(value = "/search/name/match/{name}")
	public List<Book> getBookByNameMatch(@PathVariable String name) {
		List<Book> books = bookService.findByNameMatch(name);
		return books;
	}
	@RequestMapping(value = "/search/param/{name}/{author}/{price}")
	public List<Book> getBookByNamedParam(@PathVariable String name, @PathVariable String author, @PathVariable long price) {
		List<Book> books = bookService.findByNamedParam(name, author, price);
		return books;
	}
	
	@RequestMapping(value = "/search/price/{price}")
	public List<Book> getBookByPrice(@PathVariable int price) {
		List<Book> books = bookService.findByPrice(price);
		return books;
	}
	@RequestMapping(value = "/search/price/{price1}/{price2}")
	public List<Book> getBookByPriceRange(@PathVariable int price1, @PathVariable int price2) {
		List<Book> books = bookService.findByPriceRange(price1, price2);
		return books;
	}
	@RequestMapping(value = "/search/{name}/{author}")
	public List<Book> getBookByNameAndAuthor(@PathVariable String name, @PathVariable String author) {
		List<Book> books = bookService.findByNameAndAuthor(name, author);
		return books;
	}
	
	@RequestMapping(value = "/removeAll")
	public void removeAllBooks() {
		bookService.removeAll();
	}
}
