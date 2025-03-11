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

     Project pref1;
     Project pref2;

     for(int i=0; i<Andrei.getPersonsCount();i++)
     {

      if(persons[i].getType()=="Student")
      {

       pref1= ((Student) persons[i]).getPref(0);
       pref2=((Student) persons[i]).getPref(1);

       //System.out.println("Preferintele lui " + persons[i].getName() +" sunt : "+pref1.getName()+" "+pref2.getName());
       if(!pref1.isAllocated())
       {
        ((Student) persons[i]).assignProject(pref1);
        //System.out.println("Am alocat proiectul:" + pref1);

       }
       else if (!pref2.isAllocated() && pref1.isAllocated()) {
        ((Student) persons[i]).assignProject(pref2);
        //System.out.println("Am alocat proiectul:" + pref2);
       }
       else if(pref1.isAllocated()&&pref2.isAllocated()){
        System.out.println("Nu am putut aloca proiect pentru studentul: " + persons[i].getName());
       }
      }
     }

     for(int i=0; i<Andrei.getPersonsCount();i++) {
      if (persons[i].getType() == "Student") {
       System.out.println(persons[i].getName()+" : "+((Student) Andrei.getPersons()[i]).getProjects() + "\n");
      }
     }
    // System.out.println(Dascalius.getProjectsList());




    }
}