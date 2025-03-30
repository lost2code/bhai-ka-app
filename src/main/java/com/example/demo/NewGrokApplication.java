package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;


@SpringBootApplication
@Controller
public class NewGrokApplication {
	
	private final UserRepository userRepository;

    public NewGrokApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(NewGrokApplication.class, args);
	}
	
	
	
	@GetMapping("/")
    public String home() {
        return "index"; // index.html ko return karo
    }
	
	@GetMapping("/index")
		public String showadded(Model model) {
			 List<user> users = userRepository.findAll(); // Saare users fetch karo
		     model.addAttribute("users", users);
		     if(!users.isEmpty()) {
		    	 model.addAttribute("addednames","bhai tune ye nam add kiye hn");
		     }
		     
		     return "index";
		}
	
	
	
	@GetMapping("/greet")
	public String showgreet(Model model){
		
		 model.addAttribute("greeting", "hello bhai nam add kr bs tu ");
		 model.addAttribute("userForm", new UserForm());
		 List<user> users = userRepository.findAll(); // Saare users fetch karo
		 
	     model.addAttribute("users", users);
		return "greet";
	}
		
	
	
	@PostMapping("/greet")
    public String greetUser(@Valid UserForm userForm, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
	        model.addAttribute("greeting", "Error, bhai! Check karke dobara try kar!");
	        List<user> users = userRepository.findAll();
	        model.addAttribute("userForm", userForm);
	        model.addAttribute("users", users);
	        return "greet";
	    }

	    String name = userForm.getName();
        
        	user user = new user();
            user.setName(name);
            userRepository.save(user);
            model.addAttribute("greeting", "Hello, " + name + "! Bhai, tu toh legend hai!");
            model.addAttribute("userForm", new UserForm());
        
        List<user> users = userRepository.findAll(); // Saare users fetch karo
	    model.addAttribute("users", users);
//        
       
        
        return "greet"; // greet.html ko point karta hai
    }
	
	@GetMapping("/clear")
	public String clearUsers(Model model) {
	    userRepository.deleteAll(); // Saare users delete karo
	    model.addAttribute("greeting", "Hello, Bhai! Sab clear ho gaya!");
	    List<user> users = userRepository.findAll();
	    model.addAttribute("userForm", new UserForm());
	    model.addAttribute("users",users);
	    return "greet";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id, Model model) {
	    userRepository.deleteById(id);
	    model.addAttribute("greeting", "Bhai, naam delete ho gaya!");
	    model.addAttribute("userForm", new UserForm());
	    List<user> users=userRepository.findAll();
	    model.addAttribute("users", users);
	    return "index";
	}
	
	

}






    
