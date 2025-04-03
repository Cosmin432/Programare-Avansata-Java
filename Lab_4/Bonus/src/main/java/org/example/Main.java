package org.example;

import com.github.javafaker.Faker;
import com.sun.source.tree.Tree;
import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.alg.sp.DijkstraShortestPathBase;
import org.graph4j.alg.sp.SinglePairShortestPath;
import org.graph4j.util.EdgeSet;
import org.graph4j.util.Path;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {


        Faker faker = new Faker();
        var locations = new ArrayList<Location>();
        for( int i = 0; i<100;i++)
        {
            Location cotu = new Location(LocationType.Friendly, faker.address().city());
            locations.add(cotu);
        }


        TreeSet<Location> friendlyLocations = locations.stream()
                .filter(Location::isFriendly)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Location::getName))));


        LinkedList<Location> enemyLocations = locations.stream()
                .filter(loc -> !loc.isFriendly())
                .sorted(Comparator.comparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));

        afisare(enemyLocations, friendlyLocations);
        punctDoi(locations);

    }

    static void afisare(LinkedList<Location> enemyLocations, TreeSet<Location> friendlyLocations) {
        // Print the sorted lists of locations
        System.out.println("Enemy Locations:\n");
        enemyLocations.forEach(loc -> System.out.println(loc.getName()));
        System.out.println("\nFriendly Locations:\n");
        friendlyLocations.forEach(loc -> System.out.println(loc.getName()));

    }

    static void punctDoi(List<Location> locations) {

        ArrayList<PathStuct> paths = new ArrayList<>();

        Graph graph = GraphBuilder.empty()
                .estimatedNumVertices(locations.size())
                .buildGraph();

        for (int i = 0; i < locations.size(); i++) {
            graph.addVertex(i, locations.get(i));
        }


        for (int i = 0; i < locations.size(); i++) {
            for (int j = i + 1; j < locations.size(); j++) {
                double check = Math.random();
                if (check < 0.80) {
                    double weight = Math.random() * 100;
                    graph.addEdge(i, j, weight);
                    graph.addEdge(j, i, weight);
                }
            }
        }

        for (int i = 0; i < locations.size()-1; i++) {
            Location startLocation = locations.get(i);
            int startVertex = graph.findVertex(startLocation);
            for (int j = i+1; j < locations.size(); j++) {
                Location endLocation = locations.get(j);
                int endVertex = graph.findVertex(endLocation);

                DijkstraShortestPathBase algoritm = new DijkstraShortestPathBase(graph, startVertex) {
                    @Override
                    protected int findMinIndex() {
                        return this.source;
                    }
                };
                Path path = algoritm.findPath(endVertex);
                if (path == null) {
                    System.out.println("No path found from " + startLocation + " to " + endLocation);
                    continue;
                }
                double weight = algoritm.getPathWeight(endVertex);
                PathStuct pathS = new PathStuct(path, weight);
                paths.add(pathS);

            }
        }
        for(PathStuct path :paths)
        {
            System.out.println(path);

        }
        OptionalDouble valoare = paths.stream().mapToDouble(PathStuct::getWeight).average();
        System.out.println(valoare.getAsDouble());
    }


}

