package gitHub.saad.spring.boot.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gitHub.saad.spring.boot.model.Author;
import gitHub.saad.spring.boot.model.User;
import gitHub.saad.spring.boot.model.Writer;
import gitHub.saad.spring.boot.service.BookServiceImpl;
import gitHub.saad.spring.boot.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {

	Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Resource
	private BookServiceImpl bookService;
	
	@RequestMapping(value="/")
	public List<User> getAllUsers()
	{
		return userService.findAllUsers();
	}
	
	@RequestMapping(value="/author/save")
	public void addAuthor(){
		Author user=new Author();
		user.setBooks( bookService.findAll());
		user.setName("SaadAuthor");
		user.setRef("refAuthor");
		userService.addUsers(user);
	}
	
	@RequestMapping(value="/remove/{id}")
	public void deleteAuthor(@PathVariable Long id ){
		userService.removeUsers(id);
		
	}
	@RequestMapping(value="/search/name/{name}")
	public List<User> findByName(@PathVariable String name)
	{
		return userService.findByName(name);
	}
	
	@RequestMapping(value="/search/Dtype/{type}")
	public List<User> findByNameAuthor(@PathVariable String type)
	{
		List<User> users =userService.findByDtype(type);
		log.debug(users);
		return users;
	}
	
	@RequestMapping(value="/writer/save")
	public void addWriter(){
		Writer user=new Writer();
		user.setName("SaadWriter");
		user.setRef("refWriter");
		userService.addUsers(user);
	}
	
	@RequestMapping(value="/{id}")
	public User findOneUser(@PathVariable Long id ){
		return userService.findOneUser(id);
		
	}
	
}
