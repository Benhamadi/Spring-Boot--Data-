package gitHub.saad.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class User { 
 

	//	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
	@TableGenerator(name = "User")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "User")
	private long id;
	
	@Column(name="name_User")
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
