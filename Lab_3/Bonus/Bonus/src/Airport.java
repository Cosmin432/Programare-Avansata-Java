import java.util.ArrayList;

public class Airport {
    private String name;
    private ArrayList<String> runways;

    public Airport(String name)
    {
        this.name = name;
        this.runways = new ArrayList<>();
    }

    public void addRunway(String runway) {
        runways.add(runway);
    }

    public ArrayList<String> getRunways() {
        return runways;
    }
}
