
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { EnrollmentService } from './enrollment.service';

import { Enrollment } from './enrollment';

@Component({
  selector: 'app-enrollment-info',
  templateUrl: './enrollment-info.component.html',
  styleUrls: ['./enrollment-info.component.css']
})
export class EnrollmentInfoComponent implements OnInit {

  enroll: Enrollment = new Enrollment();
  myparam: number = 0;
  enrollments: any;
  responseMessage: string = '';
  updateScoreForm: any;
  enrollmentByIDForm: any;
  scoreCourseForm: any;
  courseForm: any;
  enroll1: Enrollment | undefined;
  studentId!: string;
  trainerId!: string;
  courseId!: string;

  // Form models for different operations
  enrolls!: Enrollment[];
  enrollsSorted!: Enrollment[];
  enrollMin!: Enrollment[];
  enrollMax!: Enrollment[];
  enrollmentId!: any;
  enrollUpdated: Enrollment | undefined;



  constructor(private enrollmentService: EnrollmentService, private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.route.queryParams.subscribe((queryParams) => {
      this.myparam = queryParams['paramFlag'] || 1; 
    });
    
   


  }
  addEnrollment() {
    this.responseMessage = "";
    this.enrollmentService.addEnrollment(this.enroll, this.studentId, this.trainerId, this.courseId)
      .subscribe(
        (response: any) => {
          this.responseMessage = `Enrollment with ID ${response.enrollmentId} added successfully`;
          alert(this.responseMessage)
        },
        (error) => {
          this.responseMessage = 'Enter the existing foreign keys';
          alert(this.responseMessage)
        }
      );
  }
  updateScore() {
    this.responseMessage = "";
    this.enrollmentService.updateScore(this.enroll.enrollmentId, this.enroll.score)
      .subscribe(

        (data) => {
          // Data validation successful
          this.responseMessage = "Data successfully updated:",
            this.enrollUpdated = data as Enrollment;
            alert(this.responseMessage)
        },
        (error: any) => {
          // Data validation failed
          this.responseMessage = "Data is not updated:"
          alert(this.responseMessage)
        }
      );
  }
  viewAll() {
    this.responseMessage = "";
    this.enrollmentService.viewAll().subscribe(
      data => {
        this.enrolls = data as Enrollment[],

        console.log(this.enrolls[0].studentObj)
      },
      (error: any) => {
        // Data validation failed
        this.responseMessage = "Could not fetch all data"
        alert(this.responseMessage)
      });

  }
  viewEnrollmentByID() {
    this.responseMessage = "";
    this.enrollmentService.viewEnrollmentByID(this.enrollmentId)
      .subscribe(
        data => {
          this.enroll1 = data as Enrollment;
        },
        (error: any) => {
          // Data validation failed
          this.responseMessage = "Could not find the data"
          alert(this.responseMessage)
        }
      );
  }
  viewMaxScore() {
    this.responseMessage = "";
    this.enrollmentService.viewMaxScore().subscribe(
      data => { this.enrollMax = data as Enrollment[] },
      (error: any) => {
        // Data validation failed
        this.responseMessage = "Could not find the data"
        alert(this.responseMessage)
      });

  }
  viewScoreBySort() {
    this.responseMessage = "";
    this.enrollmentService.viewScoreBySort().subscribe(
      data => { this.enrollsSorted = data as Enrollment[] },
      (error: any) => {
        // Data validation failed
        this.responseMessage = "Could not find the data"
        alert(this.responseMessage)
      });

  }
  viewMinScore() {
    this.responseMessage = "";
    this.enrollmentService.viewMinScore().subscribe(
      data => { this.enrollMin = data as Enrollment[] },
      (error: any) => {
        // Data validation failed
        this.responseMessage = "Could not find the data"
        alert(this.responseMessage)
      });

  }
    
}
