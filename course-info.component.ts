import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { CourseService } from './course.service';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Enrollment } from '../enrollment-info/enrollment';
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
  course: Course = new Course();
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
  courseUpdated!: Course ;
  courseByCD!: Course[] ;
 // courseService: any;
  constructor(private courseService: CourseService,private route: ActivatedRoute) {
    
  }
  ngOnInit(): void {
    this.route.queryParams.subscribe(
      param =>{
        this.paramFlag = param['paramFlag']
      }
    );
  }

  addedCourse:Course=new Course();
  addCourse() {
    // Check if any of the input fields are empty
    this.successMessage="";
    this.courseService.addCourse(this.course)
      .subscribe(
        (response: any) => {
          this.addedCourse =response as Course
          this.successMessage = `Course with id ${this.addedCourse.courseId} added successfully`;
        },
        (error) => {
          this.successMessage = 'An error occurred while adding the course.';
        }
      );
  }
  responseMessage : string = "";
  updateDuration() {
    // Call the updateDuration method from the CourseService with courseId and new duration
    this.responseMessage="";
    this.courseService.updateDuration(this.courseId,this.duration)
      .subscribe(
       
        (data) => {
          // Data validation successful
          this.responseMessage="Data successfully updated:"
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
      data=>{this.courses=data as Course[]},
      (error: any) => {
        // Data validation failed
        this.successMessage="Data is not fetched:"
      });
    
  }
viewCourseByID(){
  
  this.courseService.viewCourseByID(this.courseId).subscribe(
    (data: Course) => {
      console.log(`Course ID ${this.courseId} details retrieved successfully.`);
      // Handle the retrieved course data as needed
      this.courseUpdated=data as Course;

    },
    (error: any) => {
      this.successMessage="Course Id is not available" // Display the error message from the HTTP response
    }
  );
}
viewCourseByCategoryAndDuration() {
  // Call the viewCourseByCategoryAndDuration method from the CourseService
  
  this.courseService
    .viewCourseByCategoryAndDuration(this.selectedCategory, this.selectedDuration)
    .subscribe(
      (data) => {
        console.log('View Course By Category And Duration done successfully.');
        // Handle the retrieved course data as needed
        this.courseByCD=data as Course[];

      },
      (error: any) => {
        this.successMessage="Category or Duration is not available" // Display the error message from the HTTP response
      }
    );
}
// searchCourses() {
//   // Ensure category and duration have valid values
//   if (!this.category || !this.duration) {
//     console.error('Please provide both category and duration.');
//     return;
//   }

//   // Call the viewCourseByCategoryAndDuration method from the CourseService
//   this.courseService
//     .viewCourseByCategoryAndDuration(this.category, this.duration)
//     .subscribe(
//       (data: Course) => {
//         // Handle the retrieved course data as needed
//         console.log('View Course By Category And Duration done successfully.');
//         this.course = data; // Update the courses array with the search results
//       },
//       (error: any) => {
//         console.error(error); // Display the error message from the HTTP response
//         this.courses = []; // Clear the courses array on error
//       }
//     );
// }
}