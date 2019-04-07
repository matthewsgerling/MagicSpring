
package dmacc.controllor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.SpringMagic;
import dmacc.repo.MagicRepo;

@Controller
public class WebController {
	@Autowired
	MagicRepo repo;
	
	@GetMapping("/viewAll")
	public String viewAllContacts(Model model) {
		model.addAttribute("cards", repo.findAll());
		return "results";
	}
	
	
	@GetMapping("/inputCard")
	public String addNewCard(Model model) {
	    SpringMagic c = new SpringMagic();
	    model.addAttribute("cards", c);
	    return "input";
	}
	
	@PostMapping("/inputCard")
	public String addNewCard(@ModelAttribute SpringMagic c, Model model) {
		repo.save(c);
		model.addAttribute("cards", repo.findAll());
		return "results";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		SpringMagic c = repo.findById((long) id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    model.addAttribute("cards", c);
	    return "update";
	}

	
	@PostMapping("/update/{id}")
	public String updateCard(@PathVariable("id") int id, @Valid SpringMagic c, 
			BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        c.setId(id);
	        return "update";
	    }
	         
	    repo.save(c);
	    model.addAttribute("cards", repo.findAll());
		return "results";
	}
	     
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		SpringMagic c = repo.findById((long) id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    repo.delete(c);
	    model.addAttribute("cards", repo.findAll());
		return "results";
	}
	
}