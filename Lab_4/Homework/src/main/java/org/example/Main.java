package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        var locations = new ArrayList<Location>();
        Location botosani = new Location(LocationType.Friendly, "Botosani");
        Location cotu = new Location(LocationType.Friendly, "Cotu");
        Location copalau = new Location(LocationType.Friendly, "Copalau");
        Location cerbu = new Location(LocationType.Friendly, "Cerbu");
        Location suceava = new Location(LocationType.Enemy, "Suceava");
        Location iasi = new Location(LocationType.Enemy, "Iasi");

        locations.add(botosani);
        locations.add(suceava);
        locations.add(iasi);
        locations.add(copalau);
        locations.add(cerbu);
        locations.add(cotu);

        TreeSet<Location> friendlyLocations = locations.stream()
                .filter(Location::isFriendly)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Location::getName))));

        LinkedList<Location> enemyLocations = locations.stream()
                .filter(loc -> !loc.isFriendly())
                .sorted(Comparator.comparing(Location::getName))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("Enemy Locations:\n");
        enemyLocations.forEach(loc -> System.out.println(loc.getName()));
        System.out.println("\nFriendly Locations:\n");
        friendlyLocations.forEach(loc -> System.out.println(loc.getName()));

    }
}