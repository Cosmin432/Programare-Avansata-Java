import java.util.ArrayList;
import java.util.HashSet;
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

    public boolean hasMatch() {

        if(projectsIndex<studentsIndex) {
            return false;
        }
        for (int size = 1; size <= studentsIndex; size++) {
            int[] attempt = new int[size];
            for (int i = 0; i < size; i++) {
                attempt[i] = i;
            }
            while (attempt != null) {
                if (!hasHallProp(attempt)) {
                    return false;
                }
                attempt = nextAttempt(attempt, size);
            }
        }

        return true;
    }

    private int[] nextAttempt(int[] attempt, int n) {
        int maxIndex = studentsIndex;

        for (int i = n - 1; i >= 0; i--) {
            if (attempt[i] < maxIndex - (n - i)) {
                attempt[i]++;

                for (int j = i + 1; j < n; j++) {
                    attempt[j] = attempt[j - 1] + 1;
                }
                return attempt;
            }
        }
        return null;
    }

    private boolean hasHallProp(int[] attempt) {
        int countCovered = 0;
        boolean[] visited = new boolean[sizeG];

        System.out.print("Se încearcă subsetul: ");
        for (int studentIndex : attempt) {
            System.out.print(studentIndex + " ");
        }

        System.out.println("\n");
        for (int studentIndex : attempt) {
            for (int neighbor : adjacencyList.get(studentIndex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    countCovered++;
                }
            }
        }
        return countCovered >= attempt.length;
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
