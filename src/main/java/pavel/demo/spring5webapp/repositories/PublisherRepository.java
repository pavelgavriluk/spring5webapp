package pavel.demo.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import pavel.demo.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
