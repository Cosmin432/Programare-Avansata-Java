import org.example.Location;

import java.util.List;
import java.util.stream.Collectors;

public class Route{
    private List<Location> path;
    private int friendlyCount;
    private int enemyCount;
    private double totalDistance;

    public Route(List<Location> path, int friendlyCount, int enemyCount, double totalDistance) {
        this.path = path;
        this.friendlyCount = friendlyCount;
        this.enemyCount = enemyCount;
        this.totalDistance = totalDistance;
    }

    // Getters
    public List<Location> getPath() { return path; }
    public int getFriendlyCount() { return friendlyCount; }
    public int getEnemyCount() { return enemyCount; }
    public double getTotalDistance() { return totalDistance; }

    @Override
    public String toString() {
        return "Route: " + path.stream().map(Location::getName).collect(Collectors.joining(" -> ")) +
                "\nFriendly: " + friendlyCount + " | Enemy: " + enemyCount +
                " | Distance: " + totalDistance;
    }
}