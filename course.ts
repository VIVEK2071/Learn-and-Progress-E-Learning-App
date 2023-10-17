export class Course{
  //[x: string]: any;
    courseId: string = '';
  courseName: string = '';
  duration: number = 0;
  category: string = '';
  errorMessage: string='';
  successMessage : string = '';
  message: string='';
  allCourses: any;
  paramFlag : number = 0;
  courses : any[] | undefined;
  
  selectedCategory: string = '';
  selectedDuration: number = 0;
  courseService: any;

}