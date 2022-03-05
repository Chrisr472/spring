package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "https://springboot-postgressql.herokuapp.com")
@RestController
public class Example {
	@Autowired
	private DataRepository studentRepo;
	 
	 @PostMapping("/students")
    public String create( @RequestBody Data data ) {
		
        
		 studentRepo.save(data);
			
			
        
       
        return "Created";
    }
	 @GetMapping("/studenti")
	 public String getById(@RequestParam(value="id") String i)
	 {   Integer s=Integer.parseInt(i);
		
			Data l =studentRepo.getById(s);
            return l.toString();
	 }
	 
	 @GetMapping("/student")
	    public List<Data> listById(Model model) {
			
	        
		    List<Data> listStudents = studentRepo.findAll();
	       
	        return  listStudents;
	    }
	 @DeleteMapping("/deleteall")
	 public ResponseEntity<String> delete(Model model)
	 {   
		 studentRepo.deleteAll();  
		 return  ResponseEntity.ok("Delete");
	 }
	 @PutMapping("/update")
	    public ResponseEntity<String> update(@RequestParam(value="id") String id,Model model) {
	      Data dat=studentRepo.getById(Integer.parseInt(id));
	      dat.setEmail("chrisrohan@gmail.com");
	       studentRepo.save(dat);
	        return  ResponseEntity.ok("updated");
	        
	    }

}
