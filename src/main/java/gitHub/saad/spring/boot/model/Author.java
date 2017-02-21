package gitHub.saad.spring.boot.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="AUTHOR")
public class Author extends User { 
	
	private String ref;
	
	//Composition =>l'existence de @Entity(Book) n'a de sens que si elle est en relation de @Entity(Author)
	//Relation n:p
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE} ,fetch=FetchType.LAZY)
	private Collection<Book> books;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Collection<Book> getBooks() {
		System.out.println("la collection books chargée à la demande aprés chaque appel de getBooks()");
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Author [id="+this.getId()+" name="+this.getName()+" , ref=" + ref + ", books=" + 0+ "]";
	}
	
}