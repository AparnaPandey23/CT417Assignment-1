import static org.junit.Assert.*;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class TestSystemOutput {
	
	//This file is was used to check if the classes stored information correctly 
	// and was used to create the Test files for each class thereafter
	
	
	Student student1, student2;
	ArrayList<Student> listOfStudents;
	DateTime startDate, endDate;
	Module mod1, mod2 ,mod3;
	CourseProgramme course1,course2;
	
	@Before
	public void setUp() throws Exception {
		
		// Create 2 students
		student1 = new Student("Aparna Pandey", 21, "23/01/1999", 12345678 );
		student2 = new Student("Evan Matthews", 17, "12/03/2003", 19999999);
				
		//list of students
		listOfStudents = new ArrayList<Student>();
		listOfStudents.add(student1);
		listOfStudents.add(student2);
		
		//start and end dates for course1s
		startDate = new DateTime("2020-02-12");
		endDate = new DateTime("2020-12-18");
			    
		//Courses 
		course1 = new CourseProgramme("4BCT", startDate, endDate);
		course2 = new CourseProgramme("2MAC", startDate, endDate);
		
		//Modules
		mod1 = new Module("Software Engineering 3", "CT4117");
		mod2 = new Module("Machine Learning", "CT4101");
		mod3 = new Module("Advanced Maths", "MT301");		
	}

	@Test
	public void test() {
	    
	    System.out.println("2 courses, 3 modules, 2 Students \n");
		
		student2.addModuleRegistered(mod1);
		student1.addModuleRegistered(mod1);
		student2.addCourseRegistered(course1);
		course1.addModule(mod1);
		course1.addStudent(student2);
		mod1.addStudent(student2);
		mod1.addStudent(student1);
		mod1.addAssociatedCourse(course1);
		
		
		student1.addModuleRegistered(mod2);
		student1.addCourseRegistered(course1);
		course1.addModule(mod2);
		course1.addStudent(student1);
		mod2.addStudent(student1);
		mod2.addAssociatedCourse(course1);
		
		
	    System.out.println(course1);	
		
		
		student1.addModuleRegistered(mod3);
		student1.addCourseRegistered(course1);
		course1.addModule(mod3);
		course1.addStudent(student1);
		mod3.addStudent(student1);
		mod3.addAssociatedCourse(course1);
		
		System.out.println(course1);
	    
	  
	}

}
