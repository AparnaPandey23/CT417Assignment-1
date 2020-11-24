
import java.util.ArrayList;

public final class Student {

    private String studentName; //name
    private int age; // age
    private String DOB; //Date of birth
    private long studentID; //8 digit number
    private String userName; //different from student name
	private ArrayList<CourseProgramme> registeredCourses; //list of courses registered
	private ArrayList<Module> registeredModules; //list of modules registered

	public Student(String studentName,int age, String DOB, long id)
    {
        this.studentName = studentName;
        this.age = age;
        this.DOB = DOB;
        this.studentID = id;
        this.userName = studentName + age;
        this.registeredModules = new ArrayList<Module>(); //initialize empty list
    	this.registeredCourses = new ArrayList<CourseProgramme>(); //initialize empty list
        
    }

    //setters
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setStudentID(long id) {
        this.studentID = id;
    }
    //set entire list of courses and modules
    public void setCoursesRegistered(ArrayList<CourseProgramme> registeredCourses) {
  		this.registeredCourses = registeredCourses;
  	}
    
    public void setModulesRegistered(ArrayList<Module> registeredModules) {
		this.registeredModules = registeredModules;
	}
    //add courses and modules individually to list
    public void addCourseRegistered(CourseProgramme course) {
   		this.registeredCourses.add(course);
   	}
   	
   	public void addModuleRegistered(Module module) {
   		this.registeredModules.add(module);
   	}
    
    //getters
    public String getStudentName() {
            return studentName;
        }
    
    public int getAge() {
        return age;
    }

    public String getDOB() {
        return DOB;
    }
    
    public long getStudentID() {
        return studentID;
    }
    
    public String getUserName() {
        return getStudentName() + getAge(); //concatenate name+ age of student
    }
    
   	public ArrayList<CourseProgramme> getCoursesRegistered() {
   		return registeredCourses;
   	}

    public ArrayList<Module> getModulesRegistered() {
		return registeredModules;
	}
  
    public String toString()
	{
		return "Student Details: "+ getStudentName() + ", " + getAge() + ", " + getDOB() + ", " +  getStudentID() + ", " + getUserName();
	}
    
}