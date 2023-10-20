import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  
  
  
   // updatePhoneNumber(studentId: string, phoneNumber: string) {
//     throw new Error('Method not implemented.');
//   }
  private baseUrl = 'http://localhost:8080/student'; // Adjust the base URL as needed

  constructor(private http: HttpClient) {}

  addStudent( stud: Student): Observable<Object> {
    const url = `${this.baseUrl}/addStudent`;
    
    return this.http.post(url, stud)
      .pipe(
        catchError(this.errorHandler)
      );
  }

  updatePhoneNumber(studentId: string, phoneNumber: string): Observable<Object> {
    console.log("service is called")
    const url = `${this.baseUrl}/updatePhoneNumber/${studentId}/${phoneNumber}`;
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

  viewStudentByID(studentId: string): Observable<Object> {
    const url = `${this.baseUrl}/viewStudentByID/${studentId}`;
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