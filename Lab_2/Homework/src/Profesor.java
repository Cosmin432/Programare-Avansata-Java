import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persoana {

    private List<Project> projectsList;

    public Profesor(String name, String birthDay) {

        super(name, birthDay);
        this.projectsList = new ArrayList<Project>();
        this.type = "Profesor";
    }

    public void addProject(Project project) {
        int check=1;
        for (Project p : this.projectsList) {
            if (p.equals(project)) {
                check = 0;
            }
        }
        if(check!=0) {
            this.projectsList.add(project);
        }
    }

    public List<Project> getProjectsList() {
        return projectsList;
    }

    @Override
    public String toString() {
        return "Profesor [name=" + this.getName() + ", age=" + this.getBirthDay()+ " ]";
    }

}
