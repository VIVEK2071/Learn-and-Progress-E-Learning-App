import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, ObservableInput, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private baseUrl = 'http://localhost:8080/course'; // Adjust the base URL as needed
  errorHandler!: ((err: any, caught: Observable<Object>) => ObservableInput<any>);
  //errorHandler: (err: any, caught: Observable<Object>) => ObservableInput<any>;

  constructor(private http: HttpClient) {}

  addCourse(course:any){
   const url = `${this.baseUrl}/addCourse`;
    
   return this.http.post(url, course)
     .pipe(
       catchError(this.errorHandler)
      );
  }

  updateDuration(courseId:string, duration:number){
    const url = `${this.baseUrl}/updateDuration/{courseId}/{duration}`;
    return this.http.put(url, null)
      .pipe(
        catchError(this.errorHandler)
      );
  }

  viewAll(): Observable<Object>{
    return this.http.get(this.baseUrl+'/viewAll')
      .pipe(
        catchError(this.errorHandler)
      );
  }

  viewCourseByID(courseId:string){
    const url = `${this.baseUrl}/viewCourseByID/{courseId}`;
    console.log("This course is called");
    return this.http.get(url)
      .pipe(
        catchError(this.errorHandler)
      );
  }
  viewCourseByCategoryAndDuration( category: string,duration: number) {
    return this.http.get(this.baseUrl+'/viewCourseByCategoryAndDuration/{category}/{duration}')
      .pipe(
        catchError(this.errorHandler)
      );
  }
  viewScoreBySort(): Observable<Object> {
    return this.http.get(this.baseUrl+'/viewScoreBysort')
      .pipe(
        catchError(this.errorHandler)
      );
   }
  // viewMinScore(): Observable<Object> {
  //   return this.http.get(this.baseUrl+'/viewMin')
  //     .pipe(
  //       catchError(this.errorHandler)
  //     );
  // }

  // // viewEnrollmentByScoreAndCourseId(score: number, courseId: string): Observable<Object> {
  // //   const url = `${this.baseUrl}/${score}/${courseId}`;
  // //   return this.http.get(url)
  // //     .pipe(
  // //       catchError(this.errorHandler)
  // //     );
  // // }

  // // viewEnrollmentByStudentName(studentName: string): Observable<Object> {
  // //   const url = `${this.baseUrl}/${studentName}`;
  // //   return this.http.get(url)
  // //     .pipe(
  // //       catchError(this.errorHandler)
  // //     );
  // // }

  // // viewEnrollmentByCourseId(courseId: string): Observable<Object> {
  // //   const url = `${this.baseUrl}/${courseId}`;
  // //   return this.http.get(url)
  // //     .pipe(
  // //       catchError(this.errorHandler)
  // //     );
  // // }

  // // getEnrollmentCountCoursewise(): Observable<Object> {
  // //   const url = `${this.baseUrl}/count`;
  // //   return this.http.get(url)
  // //     .pipe(
  // //       catchError(this.errorHandler)
  // //     );
  // // }

  // private errorHandler(error: HttpErrorResponse): Observable<any> {
  //   return throwError('An error occurred. Please try again later.');
  // }
}

