import java.util.ArrayList;
import java.util.List;

public class Bonus {
    private Project[] projects;
    private int projectsIndex=0;
    private Student[] students;
    private int studentsIndex=0;
    private Profesor[] profesors;
    private int profesorsIndex=0;
    private Persoana[] persons;
    private int sizeG;
    private ArrayList<ArrayList<Integer>> adjacencyList;

    public Bonus(Persoana[] persons) {
        this.persons = persons;
        this.projects = new Project[100];
        this.profesors = new Profesor[persons.length];
        this.students = new Student[persons.length];

        initLists();
    }

    public void initLists() {
        int index = persons[0].getPersonsCount();
        for (int i = 0; i < index; i++) {

            if (persons[i].getBirthDay() != null) {
                if (persons[i].getType().equals("Student")) {
                    students[this.studentsIndex++] = (Student) persons[i];
                } else if (persons[i].getType().equals("Profesor")) {
                    profesors[this.profesorsIndex++] = (Profesor) persons[i];
                }
            }
        }
        initProjects();
    }

    public void initProjects() {
        List<Project> projectsAux;
        for(int i = 0; i < profesorsIndex; i++) {
            projectsAux = profesors[i].getProjectsList();
            for(Project p : projectsAux) {
                projects[this.projectsIndex++] = p;
            }
        }
        initGraph();

    }
    public void initGraph() {
        this.sizeG = studentsIndex + projectsIndex;
        adjacencyList = new ArrayList<>(this.sizeG);


        for (int i = 0; i < this.sizeG; i++) {
            adjacencyList.add(new ArrayList<>());
        }


        for (int i = 0; i < studentsIndex; i++) {
            Student student = students[i];
            if (student != null) {
                Project pref1 = student.getPref(0);
                Project pref2 = student.getPref(1);

                int project1Index = getProjectIndex(pref1);
                int project2Index = getProjectIndex(pref2);

                if (project1Index != -1) {
                    adjacencyList.get(i).add(studentsIndex + project1Index);
                    adjacencyList.get(studentsIndex + project1Index).add(i);
                }
                if (project2Index != -1) {
                    adjacencyList.get(i).add(studentsIndex + project2Index);
                    adjacencyList.get(studentsIndex + project2Index).add(i);
                }
            }
        }
    }
    private int getProjectIndex(Project project) {
        for (int i = 0; i < projectsIndex; i++) {
            if (projects[i] == project) {
                return i;
            }
        }
        return -1;
    }

    public void printGraph() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("Nod " + i + " -> ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
