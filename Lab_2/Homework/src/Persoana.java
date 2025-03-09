public class Persoana {
    private String name;
    private String birthDay;

    public String type;
    private static Problem problem = new Problem();

    public Persoana(String name, String birthDay)
    {

        this.name = name;
        this.birthDay = birthDay;
        problem.add(this);
    }



    public String getBirthDay() {
        return this.birthDay;
    }

    public String getName() {
        return name;
    }

    public Persoana[] getPersons()
    {
         return problem.get();
    }

    public int getPersonsCount() {
        return problem.getIndex();
    }

    public String getType() {
        return type;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Persoana p = (Persoana) obj;

        return this.name.equals(p.getName()) && this.birthDay.equals(p.getBirthDay());
    }
}
