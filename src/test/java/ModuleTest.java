import static org.junit.Assert.*;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class ModuleTest {
	
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
	public void testModuleNameAndID() {
		//check if each value matches correctly or not
		assertEquals("Incorrect Name", "Software Engineering 3", mod1.getModuleName());
	    assertEquals("Incorrect ID", "CT4117", mod1.getModuleID());
	    
	    assertEquals("Incorrect Name", "Machine Learning", mod2.getModuleName());
	    assertEquals("Incorrect ID", "CT4101", mod2.getModuleID());
	    
	    assertEquals("Incorrect Name", "Advanced Maths", mod3.getModuleName());
	    assertEquals("Incorrect ID", "MT301", mod3.getModuleID());
	       
	}
	
	@Test
	public void testModuleStudentsCoursesRegistered() {
		//module has one student registration
		mod1.addStudent(student1);
	    
	    //test
	    assertEquals(1, mod1.getListOfStudents().size());
	    assertTrue(mod1.getListOfStudents().contains(student1));
	    assertEquals(0, mod1.getCourses().size());
	    
	    //module has 2 student registrations and 1 course associated
	  	mod2.setStudents(listOfStudents);
	  	mod2.addAssociatedCourse(course1);
	  	    
	  	//test
	  	assertEquals(2, mod2.getListOfStudents().size());
	  	assertTrue(mod2.getListOfStudents().contains(student1));
	  	assertTrue(mod2.getListOfStudents().contains(student2));
	  	assertEquals(1, mod2.getCourses().size());
	  	assertTrue(mod2.getCourses().contains(course1));
	    
	  	//adding module to several courses
	  	mod2.addAssociatedCourse(course2);
	  	mod1.addAssociatedCourse(course1);
	  	mod1.addAssociatedCourse(course2);
	  	
	  	//test
	  	assertEquals(2, mod2.getCourses().size());
	  	assertEquals(2, mod1.getCourses().size());
	  	assertTrue(mod2.getCourses().contains(course2));
	  	assertTrue(mod1.getCourses().contains(course1));
	  	assertTrue(mod1.getCourses().contains(course2));
	       
	}

}
