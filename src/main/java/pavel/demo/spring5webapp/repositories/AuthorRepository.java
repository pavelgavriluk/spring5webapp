package pavel.demo.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import pavel.demo.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
