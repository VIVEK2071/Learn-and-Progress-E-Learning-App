import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Feedback } from './feedback';
import { FeedbackService } from './feedback.service';

@Component({
  selector: 'app-feedback-info',
  templateUrl: './feedback-info.component.html',
  styleUrls: ['./feedback-info.component.css']
})
export class FeedbackInfoComponent implements OnInit{
  feed: Feedback = new Feedback();
  myparam: number = 0;
  feedbacks: any;
  responseMessage: string = '';
  updateFeedbackForm: any;
  enrollmentByIDForm: any;
  scoreCourseForm: any;
  courseForm: any;
  enroll1:Feedback | undefined;
  // Form models for different operations
  feeds!: Feedback[];
  feedbackId!:any;
  feedUpdated:Feedback|undefined;
  FeedbackService: any;
 
  
  
  constructor(private feedbackService: FeedbackService,private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.route.queryParams.subscribe((queryParams: { [x: string]: number; }) => {
      this.myparam = queryParams['paramFlag'] || 1; // Default to 1 if 'paramFlag' is not provided in the query parameters.
    });
    this.viewAll();
    

  }
  addFeedback() {
    this.responseMessage="";
    this.FeedbackService.addFeedback(this.feed, this.feed.enrollmentId)
      .subscribe(
        (response: any) => {
          this.responseMessage = `Feedback with ID ${response.fId} added successfully`;
        },
        () => {
          this.responseMessage = 'An error occurred while adding the feedback.';
        }
      );
  }
  updateFeedback() {
    this.responseMessage="";
    this.feedbackService.updateFeedback(this.feed.enrollmentId, this.feed.rating)
      .subscribe(
       
        data => {
          // Data validation successful
          this.responseMessage="Data successfully updated:",
          this.feedUpdated = data as Feedback;
        },
        (error: any) => {
          // Data validation failed
          this.responseMessage="Data is not updated:"
        }
      );
        

  }
  viewAll(){
    this.responseMessage="";
    
    this.feedbackService.viewAll().subscribe(
      
      data=>{this.feeds=data as Feedback[]
      }
      );
    
  }

  deleteFeedbackById() {
    this.responseMessage = "";
    this.feedbackService.deleteFeedback(this.feed.feedbackId)
      .subscribe(
        () => {
          this.responseMessage = `Feedback with ID ${this.feed.feedbackId} deleted successfully`;
        },
        () => {
          this.responseMessage = 'An error occurred while deleting the feedback.';
        }
      );
  }

}
 