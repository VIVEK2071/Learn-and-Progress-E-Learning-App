
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Trainer } from './trainer';
import { TrainerService } from './trainer.service';

@Component({
  selector: 'app-trainer-info',
  templateUrl: './trainer-info.component.html',
  styleUrls: ['./trainer-info.component.css']
})
export class TrainerInfoComponent implements OnInit {
  
  trainer:Trainer=new Trainer();
  myparam: number = 0;

  responseMessage: string = '';
  
  train1:Trainer | undefined;
  // Form models for different operations
  trainers!: Trainer[];
  trainerUpdated:Trainer | undefined;
 
 
  
  
  constructor(private trainerService: TrainerService,private route: ActivatedRoute) { }
  ngOnInit(): void {
    this.route.queryParams.subscribe((queryParams: { [x: string]: number; }) => {
      this.myparam = queryParams['paramFlag'] || 1; // Default to 1 if 'paramFlag' is not provided in the query parameters.
    });
   this.viewAll();

  }
  addTrainer() {
   // this.responseMessage="";
    this.trainerService.addTrainer(this.trainer, this.trainer.courseId)
      .subscribe(
        (response: any) => {
          this.responseMessage = `Trainer with ID ${this.trainer.trainerId} added successfully`;
        },
        (error) => {
          this.responseMessage = 'An error occurred while adding the trainer.';
        }
      );
  }
  updateCourse() {
    //this.responseMessage="";
    this.trainerService.updateCourse(this.trainer.trainerId, this.trainer.courseId)
      .subscribe(
       
        (data) => {
          // Data validation successful
          this.responseMessage="Data successfully updated:",
          this.trainerUpdated = data as Trainer;
        },
        (error: any) => {
          // Data validation failed
          this.responseMessage="Data is not updated:"
        }
      );
        

  }
  viewAll(){
    this.responseMessage="";
    this.trainerService.viewAll().subscribe(
      data=>{this.trainers=data as Trainer[]},
      );
    
  }
  viewTrainerByID() {
    //this.responseMessage="";
    this.trainerService.viewTrainerByID(this.trainer.trainerId)
      .subscribe(
        // () => {
        //   this.responseMessage = `Enrollment ID ${enrollmentID} details retrieved successfully`;
        //   // Handle enrollment data (enrollment) as needed
        // },
        // () => {
        //   this.responseMessage = `Enrollment ID ${enrollmentID} does not exist`;
        // }
        data => {
          
          this.train1=data as Trainer;

        },
        (error: any) => {
          // Data validation failed
          this.responseMessage="Data is not found:"
        }
        
        
      );
  }
}