import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Student } from './student';
import { StudentService } from './student.service';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {
 stud:Student = new Student();
 myparam :number=0;
 responseMessage: string = '';
 stud1: Student | undefined;
 studentForm:any;

 
  
 students!:Student[];
 studUpdate:Student | undefined;
  
  
  constructor(private studentService: StudentService,private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.route.queryParams.subscribe((queryParams: { [x: string]: number; }) => {
      this.myparam = queryParams['paramFlag'] || 1; // Default to 1 if 'paramFlag' is not provided in the query parameters.
    });
    
    this.viewAll();
  }
  addStudent() {
    this.responseMessage="";
  this.studentService.addStudent(this.stud)
      .subscribe(
        (response: any) => {
          this.responseMessage = `Student with ID ${this.stud.studentId} added successfully`;
        },
        (error) => {
          this.responseMessage = 'An error occurred while adding the student.';
        }
      );
  }
  updatePhoneNumber() {
    this.responseMessage="";
    console.log("component is called")
    this.studentService.updatePhoneNumber(this.stud.studentId, this.stud.phoneNumber).subscribe(
       
        (data) => {
          // Data validation successful
          this.responseMessage="Data successfully updated:",
          this.studUpdate= data as Student;
        },
        (error: any) => {
          // Data validation failed
          this.responseMessage="Data is not updated:"
        }
      );
        

  }
  viewAll(){
    this.responseMessage="";
    this.studentService.viewAll().subscribe(
      data=>{this.students=data as Student[],
        console.log(data)},
        (error: any) => {
          // Data validation failed
          this.responseMessage="Data is not fetched:"
        }
      );
    
  }
  viewStudentByID() {
    this.responseMessage="";
    this.studentService.viewStudentByID(this.stud.studentId)
      .subscribe(
       
        data => {
          
          this.stud1=data as Student;

        },
        (error: any) => {
          // Data validation failed
          this.responseMessage="Data is not fetched:"
        }
        
      );
  }
 
}