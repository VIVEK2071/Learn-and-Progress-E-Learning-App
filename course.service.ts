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

  addCourse(course:any):Observable<Course>{
   const url = `${this.baseUrl}/addCourse`;
    
   return this.http.post(url, course)
     .pipe(
       catchError(this.errorHandler)
      );
  }

  updateDuration(courseId:string, duration:number){
    const url = `${this.baseUrl}/updateDuration/${courseId}/${duration}`;
    return this.http.put(url, null)
      .pipe(
        catchError(this.errorHandler)
      );
  }

  viewAll(): Observable<Object>{
    return this.http.get(this.baseUrl+`/viewAll`)
      .pipe(
        catchError(this.errorHandler)
      );
  }

  viewCourseByID(courseId:string){
    const url = `${this.baseUrl}/viewCourseByID/${courseId}`;
    
    return this.http.get(url)
      .pipe(
        catchError(this.errorHandler)
      );
  }
  viewCourseByCategoryAndDuration( category: string,duration: number) {
    return this.http.get(this.baseUrl+`/viewCourseByCategoryAndDuration/${category}/${duration}`)
      .pipe(
        catchError(this.errorHandler)
      );
  }
  
}