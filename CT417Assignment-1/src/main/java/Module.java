
import java.util.ArrayList;

public final class Module {

    private String moduleName;
    private String moduleID;
    private ArrayList<Student> listOfStudents; //stores list of student ids
	private ArrayList<CourseProgramme> associatedCourse; //stores list of associated courses
    
    public Module(String moduleName, String moduleId)
	{
          this.moduleName = moduleName;
          this.moduleID = moduleId; 
          this.listOfStudents = new ArrayList<Student>();
          this.associatedCourse = new ArrayList<CourseProgramme>();
     }
    
    //getters
    public String getModuleName() {
    	return moduleName;
    }
    
    public String getModuleID() {
    	return moduleID;
    }
    
    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }
    
    public ArrayList<CourseProgramme> getCourses() {
        return this.associatedCourse;
    }
    
    //setters
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public void setId(String moduleId) {
        this.moduleID = moduleId;
    }
    
    //add one student at a time
    public void addStudent(Student student) {
        this.listOfStudents.add(student);
    }
    
    //add list of students
    public void setStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }
    
   
    //add one course at a time
    public void addAssociatedCourse(CourseProgramme course) {
        this.associatedCourse.add(course);
    }
    
    //add list of courses
    public void setCourses(ArrayList<CourseProgramme> courses) {
        this.associatedCourse = courses;
    }
    
    public String returnStudentListString(){
    	String s= "";
    	for (Student student: listOfStudents) //iterate list 
        { s += "\t- "+ student.getStudentName() + "\n";
        }
		return s;
    }
    
    public String toString()
	{
		return "\nName: "+ getModuleName() + "\nCode:" + getModuleID() + "\n" + 
				"Registered Students: \n" + returnStudentListString(); 
	}
    
}