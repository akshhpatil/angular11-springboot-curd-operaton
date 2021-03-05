package com.example.angularspringbootdemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StudentController {
	
        @Autowired
	    private StudentRepository studRepo;
        
      @GetMapping("/stud")
      public List<Student> getAllstud() {
      return studRepo.findAll();
      		}
      	   
       @GetMapping("/stud/{id}")
      		public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId)
      				throws ResourceNotFoundException {
      			Student student = studRepo.findById(studentId)
      					.orElseThrow(() -> new ResourceNotFoundException("not found for this id :: " + studentId));
      			return ResponseEntity.ok().body(student);
       }
       
       @PostMapping(value = "/stud")
 	   public ResponseEntity<Student> postStudent(@RequestBody Student student) {
 	    try {
 	      Student _student = studRepo.save(new Student( 0, 
 	    		  student.getName(),
 	    		  student.getEmail(),
 	    		  student.getPhone(), 
	    		  student.getBranch(),
 	    		  student.getAddress()));
 	      return new ResponseEntity<>(_student, HttpStatus.CREATED);
 	    } catch (Exception e) {
 	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
 	    }
 	  }
       
       @PutMapping("/stud/{id}")
	    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
	         @Validated @RequestBody Student studentDetails) throws RelationNotFoundException {
	        Student student = studRepo.findById(studentId)
	        .orElseThrow();

	        student.setEmail(studentDetails.getEmail());
	        student.setName(studentDetails.getName());
	        student.setPhone(studentDetails.getPhone());
	        student.setBranch(studentDetails.getBranch());
	        student.setAddress(studentDetails.getAddress());
	        final Student updatedStudent = studRepo.save(student);
	        return ResponseEntity.ok(updatedStudent);
	    }
	   
	   @DeleteMapping("/stud/{id}")
	    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId)
	         throws RelationNotFoundException {
	        Student student = studRepo.findById(studentId)
	       .orElseThrow();

	        studRepo.delete(student);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
       

}
