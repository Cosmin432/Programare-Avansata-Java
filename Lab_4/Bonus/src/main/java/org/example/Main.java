package org.example;

import com.github.javafaker.Faker;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.alg.sp.SinglePairShortestPath;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {


        Faker faker = new Faker();
        var locations = new ArrayList<Location>();

        // Generate random location names using Faker
        Location botosani = new Location(LocationType.Friendly, faker.address().city());
        Location cotu = new Location(LocationType.Friendly, faker.address().city());
        Location copalau = new Location(LocationType.Friendly, faker.address().city());
        Location cerbu = new Location(LocationType.Friendly, faker.address().city());
        Location suceava = new Location(LocationType.Enemy, faker.address().city());
        Location iasi = new Location(LocationType.Enemy, faker.address().city());

        locations.add(botosani);
        locations.add(suceava);
        locations.add(iasi);
        locations.add(copalau);
        locations.add(cerbu);
        locations.add(cotu);

        // Sort and filter friendly locations
        TreeSet<Location> friendlyLocations = locations.stream()
                .filter(Location::isFriendly)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Location::getName))));

        // Sort and filter enemy locations
        LinkedList<Location> enemyLocations = locations.stream()
                .filter(loc -> !loc.isFriendly())
                .sorted(Comparator.comparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));

        //afisare(enemyLocations,friendlyLocations);
        //punctDoi(locations);
        //punctTrei(locations);
    }
    static void afisare(LinkedList<Location> enemyLocations, TreeSet<Location> friendlyLocations) {
        // Print the sorted lists of locations
        System.out.println("Enemy Locations:\n");
        enemyLocations.forEach(loc -> System.out.println(loc.getName()));
        System.out.println("\nFriendly Locations:\n");
        friendlyLocations.forEach(loc -> System.out.println(loc.getName()));

    }

    static void punctDoi(List<Location> locations) {

        Graph graph = GraphBuilder.empty()
                .estimatedNumVertices(locations.size())
                .buildGraph();


        for (int i = 0; i < locations.size(); i++) {
            graph.addVertex(i, locations.get(i));
        }


        for (int i = 0; i < locations.size(); i++) {
            Location currentLocation = locations.get(i);

            if (i + 1 < locations.size()) {
                double weight = Math.random() * 100;
                graph.addEdge(i, i + 1, weight);
            }
        }


        Location startLocation = locations.get(0);
        Location endLocation = locations.get(locations.size() - 1);

        int startVertex = graph.findVertex(startLocation);
        int endVertex = graph.findVertex(endLocation);

        SinglePairShortestPath algorithm = SinglePairShortestPath.getInstance(graph, startVertex, endVertex);
        double shortestPathWeight = algorithm.getPathWeight();
        System.out.println("Weight of shortest path: " + shortestPathWeight);

    }
    static void punctTrei(List<Location> locations) {

        Map<LocationType, List<Location>> locationsByType = locations.stream()
                .collect(Collectors.groupingBy(Location::getType));


        locationsByType.forEach((type, locList) -> {
            System.out.println(type + ":");
            locList.forEach(loc -> System.out.println(" - " + loc.getName()));
        });
    }
}

static Map<String, Route> computeSafestRoutes(List<Location> locations) {
    Graph graph = GraphBuilder.empty();

    Map<String, Route> safestRoutes = new HashMap<>();

    for (int i = 0; i < locations.size(); i++) {
        for (int j = i + 1; j < locations.size(); j++) {
            Location start = locations.get(i);
            Location end = locations.get(j);

            DijkstraShortestPath dijkstra = new DijkstraShortestPath(graph, i);
            double distance = dijkstra.getPathWeight(j);
            List<Integer> pathVertices = dijkstra.getPathVertices(j);

            // Extrage locațiile din pathVertices
            List<Location> pathLocations = pathVertices.stream()
                    .map(locations::get)
                    .collect(Collectors.toList());

            // Numără locațiile Friendly/Enemy
            int friendly = (int) pathLocations.stream().filter(Location::isFriendly).count();
            int enemy = pathLocations.size() - friendly;

            // Cheia pentru map: "Start->End" (e.g., "Botosani->Suceava")
            String key = start.getName() + "->" + end.getName();
            safestRoutes.put(key, new Route(pathLocations, friendly, enemy, distance));
        }
    }

    return safestRoutes;
}