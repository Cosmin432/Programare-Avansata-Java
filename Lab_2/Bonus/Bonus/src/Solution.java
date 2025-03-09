public class Solution {
    public static void main(String[] args) {


     Student Andrei = new Student("Andrei","01/01/2004");
     Student Ion = new Student("Ion","01/01/2004");
     Student Florin = new Student("Florin","01/01/2004");
     Profesor Dascalius = new Profesor("Dascalius","01/01/2080");

     Project P1 = new Project();
     Project P2 = new Project();
     Project P3 = new Project();

     P1.setName("P1");
     P1.setType(Project.Type.practical);

     P2.setName("P2");
     P2.setType(Project.Type.practical);

     P3.setName("P3");
     P3.setType(Project.Type.theoretical);

     Dascalius.addProject(P1);
     Dascalius.addProject(P2);
     Dascalius.addProject(P3);

     Andrei.addPref(P1 , P3);
     Florin.addPref(P1 , P3);
     Ion.addPref(P2 , P3);

     Persoana[] persons = Andrei.getPersons();


     Bonus bonus = new Bonus(persons);
     bonus.printGraph();



    }
}