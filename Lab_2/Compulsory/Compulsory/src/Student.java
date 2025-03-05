import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;

    private List<Project> projects;


    public Student(String name, int age , Project p1 , Project p2) {
        this.name = name;
        this.age = age;
        this.projects = new ArrayList<Project>();

        projects.add(p1);
        projects.add(p2);
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public List<Project> getProjects() {
        return projects;
    }
@Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", projects=" + this.projects + "]";
}
}
