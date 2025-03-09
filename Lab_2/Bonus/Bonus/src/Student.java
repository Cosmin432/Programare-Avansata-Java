public class Student extends Persoana {

    private Project project;

    private Project[] projectsPref;
    private int registrationNumber;


    public Student(String name, String birthDay){
        super(name, birthDay);
        projectsPref = new Project[2];
        this.type = "Student";
    }

    public void assignProject(Project p1) {
        this.project = p1;
        p1.allocate();
    }

    public void addPref(Project p1 , Project p2) {
        this.projectsPref[0] = p1;
        this.projectsPref[1] = p2;
    }
    public Project getPref(int index)
    {
        return this.projectsPref[index];
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(int p1) {
        this.registrationNumber = p1;
    }

    public Project getProjects() {
        return this.project;
    }
@Override
    public String toString() {
        return "Student [name=" + this.getName() + ", age=" + this.getBirthDay() + ", projects=" + this.project + "]";
}
}
