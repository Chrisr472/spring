package com.example.demo;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "https://springboot-postgressql.herokuapp.com")
@RestController
public class Example {
	@Autowired
	private DataRepository studentRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private NewEmployeeDetailsRepo employeeRepo;
	
	 @GetMapping("/student")
	    public List<Data> ll(Model model) {
			
	        
		 List<Data> l=studentRepo.findAll();				
				
	        
	       
	         return l ;
	    }
	 @GetMapping("/admin")
	 public  String  admin(@RequestParam(name="email") String  email,@RequestParam(name="password") String  password)
	 {
		 return (email.equals("admin")&&password.equals("root"))?"Logged In":"Invalid password";
	 }
	 @PostMapping("/students")
    public String create( @RequestBody Data data ) {
		
        
		 studentRepo.save(data);
			
			
        
       
         return "Created";
    }
	 @GetMapping("/studenti")
	 public String getById(@RequestParam(value="id") String i)
	 {      Integer s=Integer.parseInt(i);
		    
			Data l =studentRepo.getById(s);
            return l.toString();
	 }
	 
	 @GetMapping("/address")
	    public List<Address> listById(Model model) {
		   
		   
		    
			List<Address> ad= addressRepo.findAll();
	        
		    
	       
	        return  ad;
	    }
	 
	 @GetMapping("/employee")
	    public NewEmployeeDetails list(Model model) {
		 addressRepo.save(new Address("No.98,3rd Cross","Ponnagar Trichy ","620001","TamilNdau","Indwwddwa"));
		 NewEmployeeDetails ee= new NewEmployeeDetails("Chris Rohan ","22/11/2000","Manivannan S M","Shirley Mary Vanitha ","8825896232",addressRepo.findAll());
		   employeeRepo.save(ee);
		  
		   
		  return ee;
	         
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
