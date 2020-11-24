import static org.junit.Assert.*;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class CourseProgrammeTest {
	
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
	public void testCourseName() {
		//check if each value matches correctly or not
		assertEquals("Incorrect Name", "4BCT", course1.getCourseName());
		assertEquals("Incorrect Name", "2MAC", course2.getCourseName());
	    
	}
	
	@Test
	public void testCourseDates() {
		
		
		//check if each value matches correctly or not
		assertEquals("Incorrect Start Date", "2020-02-12", course1.getStartDate().toString("yyyy-MM-dd"));
		assertEquals("Incorrect End Date", "2020-12-18", course1.getEndDate().toString("yyyy-MM-dd"));
	    assertNotNull("Missing Start Date", course1.getStartDate());
	    assertNotNull("Missing End Date", course1.getEndDate());
	    
	    assertEquals("Incorrect Start Date", "2020-02-12", course2.getStartDate().toString("yyyy-MM-dd"));
		assertEquals("Incorrect End Date", "2020-12-18", course2.getEndDate().toString("yyyy-MM-dd"));
	    assertNotNull("Missing Start Date", course2.getStartDate());
	    assertNotNull("Missing End Date", course2.getEndDate());
	    
	}
	
	@Test
	public void testStudentModuleRegistration() {
		//add 1 module to a course
		course1.addModule(mod1);
	    
	    //test
	    assertEquals(1, course1.getlistOfModules().size());
	    assertTrue(course1.getlistOfModules().contains(mod1));
	    assertEquals(0, course1.getlistOfStudentsEnrolled().size());
	    
	    //course has 2 module registrations and 1 student
	    course2.addModule(mod2);
	    course2.addModule(mod3);
	    course2.addStudent(student1);
	  	    
	  	//test
	    assertEquals(2, course2.getlistOfModules().size());
	    assertTrue(course2.getlistOfModules().contains(mod2));
	    assertTrue(course2.getlistOfModules().contains(mod3));
	    assertEquals(1, course2.getlistOfStudentsEnrolled().size());
	    assertTrue(course2.getlistOfStudentsEnrolled().contains(student1));
	    
	  	//adding several module and students to the courses
	    course1.addModule(mod2);
	    course1.addStudent(student1);
	    course2.addModule(mod1);
	    course2.addStudent(student2);

	  	
	  	//test
	    assertEquals(2, course1.getlistOfModules().size());
	    assertTrue(course1.getlistOfModules().contains(mod1));
	    assertTrue(course1.getlistOfModules().contains(mod2));
	    assertEquals(1, course1.getlistOfStudentsEnrolled().size());
	    assertTrue(course1.getlistOfStudentsEnrolled().contains(student1));
	    
	    assertEquals(3, course2.getlistOfModules().size());
	    assertTrue(course2.getlistOfModules().contains(mod1));
	    assertTrue(course2.getlistOfModules().contains(mod2));
	    assertTrue(course2.getlistOfModules().contains(mod3));
	    assertEquals(2, course2.getlistOfStudentsEnrolled().size());
	    assertTrue(course2.getlistOfStudentsEnrolled().contains(student1));
	    assertTrue(course2.getlistOfStudentsEnrolled().contains(student2));
	       
	}

}
