package gitHub.saad.spring.boot.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="AUTHOR")
public class Author extends User { 
	
	private String ref;
	
	//Composition =>l'existence de @Entity(Book) n'a de sens que si elle est en relation de @Entity(Author)
	//Relation n:p
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE} )
	private Collection<Book> books;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Author [id="+this.getId()+" name="+this.getName()+" , ref=" + ref + ", books=" + books + "]";
	}
	
}