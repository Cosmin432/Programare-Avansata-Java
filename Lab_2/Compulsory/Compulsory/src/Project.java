public class Project {
    public enum Type{
        theoretical , practical
    };

    private Type type;
    private String name;

    public Project() {
        this.name = "Default";
        this.type = Type.theoretical ;

    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setType(Type type){
        this.type = type;
    }
    public Type getType(){
        return this.type;
    }
    @Override
    public String toString()
    {
        return "Proiect [ nume= " + this.name+ " tip= "+ this.type+"]";
    }

}
