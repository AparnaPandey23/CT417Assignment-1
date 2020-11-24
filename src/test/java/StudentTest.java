import static org.junit.Assert.*;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	
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

	//check if values are correctly set and returned by helper functions
	@Test
	public void testStudentGetterSetters() {
		//check if each value matches correctly or not
		assertEquals("Incorrect Name", "Aparna Pandey", student1.getStudentName());
	    assertEquals("Incorrect Age", 21, student1.getAge());
	    assertEquals("Incorrect Date of Birth", "23/01/1999", student1.getDOB());
	    assertEquals("Incorrect Student Id", 12345678, student1.getStudentID());
	    
	    assertEquals("Incorrect Name", "Evan Matthews", student2.getStudentName());
	    assertEquals("Incorrect Age", 17, student2.getAge());
	    assertEquals("Incorrect Date of Birth", "12/03/2003", student2.getDOB());
	    assertEquals("Incorrect Student Id", 19999999, student2.getStudentID());
	    
	    //as no student or module is assigned to any course:
	    assertEquals(0, student1.getCoursesRegistered().size());
	    assertEquals(0, course1.getlistOfStudentsEnrolled().size());
	    assertFalse(course1.getlistOfStudentsEnrolled().contains(student1));
	    assertFalse(student1.getCoursesRegistered().contains(course1));
	}
	
	 //Add modules and courses to students and test for correctness
	@Test
	public void testStudentRegistration() {
		//student registers for 1 module 
	    student1.addModuleRegistered(mod1);
	    
	    //test
	    assertEquals(1, student1.getModulesRegistered().size());
	    assertTrue(student1.getModulesRegistered().contains(mod1));
	    assertEquals(0, student1.getCoursesRegistered().size());
	    
	    //student registers for 2 modules and 1 course
	    student2.addModuleRegistered(mod2);
	    student2.addModuleRegistered(mod3);
	    student2.addCourseRegistered(course1);
	    
	    //test
	    assertEquals(2, student2.getModulesRegistered().size());
	    assertTrue(student2.getModulesRegistered().contains(mod2));
	    assertTrue(student2.getModulesRegistered().contains(mod3));
	    assertTrue(student2.getCoursesRegistered().contains(course1));
	   
	   
	    //adding students to multiple courses
	    student1.addCourseRegistered(course1);
	    student1.addCourseRegistered(course2);
	    student2.addCourseRegistered(course2);
	   
	    //test
	    assertEquals(2, student1.getCoursesRegistered().size());
	    assertTrue(student1.getCoursesRegistered().contains(course1));
	    assertTrue(student1.getCoursesRegistered().contains(course2));
	    
	    assertEquals(2, student2.getCoursesRegistered().size());
	    assertTrue(student2.getCoursesRegistered().contains(course2));
	    
	}
	
	@Test
	public void testStudentUserName() {
		//test (name+age) 
		assertEquals("Aparna Pandey21", student1.getUserName());
		assertEquals("Evan Matthews17", student2.getUserName());    
	}


}
