package pavel.demo.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pavel.demo.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	// fields
	private AuthorRepository authorRepository;

	// constructors
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	// request methods
	@RequestMapping("/authors")
	public String getAllAuthors(Model model){
		model.addAttribute("authors", authorRepository.findAll());
		return "authors";
	}

}
