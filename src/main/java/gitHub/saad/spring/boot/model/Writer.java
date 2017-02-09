package gitHub.saad.spring.boot.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Writer")
public class Writer  extends User{
	
	private String ref;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}
	
	@Override
	public String toString() {
		return "Writer [id="+this.getId()+" name="+this.getName()+" , ref=" + ref + "]";
	}
}
