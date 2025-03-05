public class Main {
    public static void main(String[] args) {


        Project p1 = new Project();
        Project p2 = new Project();

        p1.setName("P1");
        p2.setName("P2");

        p1.setType(Project.Type.practical);
        p2.setType(Project.Type.theoretical);

        Student s1 = new Student("Andrei",20 ,p1,p2);

        System.out.println(s1.toString());
        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }
}