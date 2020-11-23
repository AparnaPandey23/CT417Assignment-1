import java.util.ArrayList;
import org.joda.time.DateTime;

public class CourseProgramme {
    private String courseName;
    private ArrayList<Module> listOfModules; //list
    private ArrayList<Student> listOfStudents; //list
    
    //Joda Time: course start and end date
    private DateTime startDate = new DateTime();
    private DateTime endDate = new DateTime();  
	
    public CourseProgramme(String courseName, DateTime startDate, DateTime endDate)
    {
        this.courseName = courseName;
        
        this.listOfModules = new ArrayList<Module>(); //initialize
        this.listOfStudents = new ArrayList<Student>(); //initialize
        
        this.startDate = startDate;
        this.endDate = endDate;
    }
    //setters
    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public void setlistOfModules(ArrayList<Module> listOfModules) {
        this.listOfModules = listOfModules;
    }
    
    public void setlistOfStudentsEnrolled(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }
    
    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }
    
    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }
    
    //add an individual module
    public void addModule(Module module) {
    	module.addAssociatedCourse(this);
        this.listOfModules.add(module);
    }
    
    //add an individual student
    public void addStudent(Student student) {
    	student.addCourseRegistered(this);
        this.listOfStudents.add(student);
    }
    
    //getters
    public String getCourseName() {
        return courseName;
    }    

    public ArrayList<Module> getlistOfModules() {
        return listOfModules;
    }

    public ArrayList<Student> getlistOfStudentsEnrolled() {
    	return listOfStudents;
    }
 
    public Student getStudent(Long studentId) {
        for (Student student: listOfStudents) //iterate list and look for matching student id
        { if(student.getStudentID() == studentId) return student;
        }
		return null;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }
    
    public Module getModule(String moduleId) {
        for (Module module: listOfModules) //iterate list and look for matching module id
        { if(module.getModuleID() == moduleId) return module;
        }
		return null;
    }
    
    public String toString()
	{
		return "Course Name: "+ getCourseName() + "\nList of modules:\n" + getlistOfModules() + "\n";
	}
}