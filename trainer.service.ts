import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {
  private baseUrl = 'http://localhost:8080/trainer'; // Adjust the base URL as needed

  constructor(private http: HttpClient) {}

  addTrainer(trainer: any, courseId: string): Observable<Object> {
    const url = `${this.baseUrl}/addTrainer/${courseId}`;
    
    return this.http.post(url, trainer)
      .pipe(
        catchError(this.errorHandler)
      );
  }

  updateCourse(trainerId: string, courseId: string): Observable<Object> {
    const url = `${this.baseUrl}/updateCourse/${trainerId}/${courseId}`;
    return this.http.put(url, null)
      .pipe(
        catchError(this.errorHandler)
      );
  }

  viewAll(): Observable<Object> {
    return this.http.get(this.baseUrl+'/viewAll')
      .pipe(
        catchError(this.errorHandler)
      );
  }

  viewTrainerByID(trainerId: string): Observable<Object> {
    const url = `${this.baseUrl}/viewTrainerByID/${trainerId}`;
    console.log("This service is called");
    return this.http.get(url)
      .pipe(
        catchError(this.errorHandler)
      );
  }
  
  private errorHandler(error: HttpErrorResponse): Observable<any> {
    return throwError('An error occurred. Please try again later.');
  }
}
