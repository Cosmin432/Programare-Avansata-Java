public class Problem {
    private static Persoana[] persons;
    private int index;

    public Problem() {
        persons = new Persoana[100];
        this.index = 0;

    }

    public void add(Persoana p) {
        int check=1;
        for (int i = 0; i < this.index; i++) {
            if(persons[i].equals(p)) {
               check=0;

            }
        }

        if(check!=0) {
            persons[index++] = p;
        }
    }
    public Persoana[] get() {
        return persons;
    }
    public int getIndex() {
        return index;
    }

}
