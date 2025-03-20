abstract class Aircraft {
    private String name;
    private int capacity;

    private int id;
    public void setName(String name) {
        this.name = name;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getId() {
        return id;
    }
}
