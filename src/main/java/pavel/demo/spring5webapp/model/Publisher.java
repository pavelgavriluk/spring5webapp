package pavel.demo.spring5webapp.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Publisher {

	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;

	// constructors
	public Publisher(String name, String address) {
		this.name = name;
		this.address = address;
	}


	// equals and hashCode
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Publisher)) {
			return false;
		}
		Publisher publisher = (Publisher) o;
		return id.equals(publisher.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
