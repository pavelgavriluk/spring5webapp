package pavel.demo.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import pavel.demo.spring5webapp.model.Author;
import pavel.demo.spring5webapp.model.Book;
import pavel.demo.spring5webapp.model.Publisher;
import pavel.demo.spring5webapp.repositories.AuthorRepository;
import pavel.demo.spring5webapp.repositories.BookRepository;
import pavel.demo.spring5webapp.repositories.PublisherRepository;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	// fields
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PublisherRepository publisherRepository;


	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData(){
		Publisher harperPublisher = new Publisher("Harper Collins", "515 Broadway Avenue");
		publisherRepository.save(harperPublisher);
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", harperPublisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(ddd);

		Publisher worxPublisher = new Publisher("Worx", "515 Broadway Avenue");
		publisherRepository.save(worxPublisher);
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23444", worxPublisher);
		rod.getBooks().add(noEJB);

		authorRepository.save(rod);
		bookRepository.save(noEJB);




	}
}
