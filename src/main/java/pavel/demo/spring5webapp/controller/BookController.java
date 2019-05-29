package pavel.demo.spring5webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pavel.demo.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

	// fields
	private BookRepository bookRepository;

	// constructors
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// request methods
	@RequestMapping("/books")
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books";
	}

}
