import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  student: Student = new Student();
  
  constructor(private studentService: StudentService,
    private router: Router) { }

  ngOnInit() {
  }

  newStudent(): void {
    
    this.student = new Student();
  }
 
  save() {
    this.studentService.createStudent(this.student)
      .subscribe(
        data => {
          this.router.navigate(['stud']);
          console.log(data);
          
        },
        error => console.log(error));
    this.student = new Student();
  }
 
  onSubmit() {
    this.save();
  }

  

}
