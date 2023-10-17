import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { CourseService } from './course.service';
import { ActivatedRoute, RouterModule } from '@angular/router';
//


import { EnrollmentService } from '../enrollment-info/enrollment.service';
import { Course } from './course';
import { CourseService } from './course.service';
//import { Course1 } from './course';


@Component({
  selector: 'app-course-info',
  templateUrl: './course-info.component.html',
  styleUrls: ['./course-info.component.css']
})
export class CourseInfoComponent implements OnInit {
  course1: Course = new Course();
  courseId: string = '';
  courseName: string = '';
  duration: number = 0;
  category: string = '';
  errorMessage: string='';
  successMessage : string = '';
  message: string='';
  allCourses: any;
  paramFlag : number = 0;
  courses : Course[] | undefined;
  
  selectedCategory: string = '';
  selectedDuration: number = 0;
  courseUpdated: Course | undefined;
 // courseService: any;
  constructor(private courseService: CourseService,private route: ActivatedRoute) {
    
  }
  ngOnInit(): void {
    this.route.queryParams.subscribe(
      param =>{
        this.paramFlag = param['paramFlag']
      }
    );
    this.viewAll();
  }
  addCourse() {
    // Check if any of the input fields are empty
    this.successMessage="";
    this.courseService.addCourse(this.course1)
      .subscribe(
        (response: any) => {
          this.successMessage = `Course with id ${this.courseId} added successfully`;
        },
        (error: any) => {
          this.successMessage = 'An error occurred while adding the course.';
        }
      );
  }
  updateDuration() {
    // Call the updateDuration method from the CourseService with courseId and new duration
    //this.successMessage="";
    this.courseService.updateDuration(this.course1.courseId,this.course1.duration)
      .subscribe(
       
        (data) => {
          // Data validation successful
          this.successMessage="Data successfully updated:"
          this.courseUpdated = data as Course;
        },
        (error: any) => {
          // Data validation failed
          this.successMessage="Data is not updated:"
        }
      );
        
  }
  viewAll(){
    this.successMessage="";
    this.courseService.viewAll().subscribe(
      data=>{this.courses=data as Course[]});
    
  }
viewCourseByID(){
  this.courseService.viewCourseByID(this.courseId).subscribe(
    (data: Course) => {
      console.log(`Course ID ${this.courseId} details retrieved successfully.`);
      // Handle the retrieved course data as needed
    },
    (error: any) => {
      console.error(error); // Display the error message from the HTTP response
    }
  );
}
viewCourseByCategoryAndDuration() {
  // Call the viewCourseByCategoryAndDuration method from the CourseService
  this.courseService
    .viewCourseByCategoryAndDuration(this.category, this.duration)
    .subscribe(
      (data: Course) => {
        console.log('View Course By Category And Duration done successfully.');
        // Handle the retrieved course data as needed
      },
      (error: any) => {
        console.error(error); // Display the error message from the HTTP response
      }
    );
}
searchCourses() {
  // Ensure category and duration have valid values
  if (!this.category || !this.duration) {
    console.error('Please provide both category and duration.');
    return;
  }

  // Call the viewCourseByCategoryAndDuration method from the CourseService
  this.courseService
    .viewCourseByCategoryAndDuration(this.category, this.duration)
    .subscribe(
      (data: Course) => {
        // Handle the retrieved course data as needed
        console.log('View Course By Category And Duration done successfully.');
        this.course1 = data; // Update the courses array with the search results
      },
      (error: any) => {
        console.error(error); // Display the error message from the HTTP response
        this.courses = []; // Clear the courses array on error
      }
    );
}
}





