package pavel.demo.spring5webapp.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.SQLInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;
	@OneToOne
	private Publisher publisher;

	@ManyToMany
	@JoinTable(name="authors_book", joinColumns = @JoinColumn(name ="book_id"),
	inverseJoinColumns = @JoinColumn(name= "author_id"))
	private Set<Author> authors = new HashSet<>();

	// constructors
	public Book(String title, String isbn, Publisher publisher) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}

	// equals and hashCode
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Book)) {
			return false;
		}
		Book book = (Book) o;
		return id.equals(book.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
