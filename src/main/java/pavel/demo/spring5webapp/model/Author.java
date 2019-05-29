package pavel.demo.spring5webapp.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {


	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

	// constructors
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// equals and hashCode
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Author)) {
			return false;
		}
		Author author = (Author) o;
		return id.equals(author.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
