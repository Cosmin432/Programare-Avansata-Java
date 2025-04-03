package org.example;

import org.graph4j.util.Path;

public class PathStuct {
    Path path;
    double weight;

    PathStuct(Path path, double weight) {
        this.path = path;
        this.weight = weight;
    }
    double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "PathStuct [path=" + path + ", weight=" + weight + "]";
    }
}
