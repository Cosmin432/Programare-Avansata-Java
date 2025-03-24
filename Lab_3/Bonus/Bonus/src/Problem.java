import java.time.LocalTime;
import java.util.*;

public class Problem {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>();

        flights.add(new Flight("111ABC", LocalTime.of(8, 0), LocalTime.of(10, 0)));
        flights.add(new Flight("111DEF", LocalTime.of(9, 0), LocalTime.of(13, 0)));
        flights.add(new Flight("111GHI", LocalTime.of(9, 30), LocalTime.of(14, 0)));
        flights.add(new Flight("111JKL", LocalTime.of(10, 0), LocalTime.of(12, 0)));
        flights.add(new Flight("111MNO", LocalTime.of(11, 0), LocalTime.of(13, 30)));
        flights.add(new Flight("111PQR", LocalTime.of(22, 30), LocalTime.of(23, 0)));
        flights.add(new Flight("111STU", LocalTime.of(20, 0), LocalTime.of(21, 0)));



        int minRunways = findMinimumRunwaysBruteForce(flights);
        System.out.println("Numărul minim de piste necesare: " + minRunways);


        boolean success = assignRunwaysBalanced(flights, minRunways);


        if (!success) {
            int requiredRunways = findMinimumRunwaysBruteForce(flights);
            System.out.println("Nu putem folosi doar " + minRunways);
            System.out.println("Avem nevoie de cel puțin " + requiredRunways);
        }
    }


    private static int findMinimumRunwaysBruteForce(List<Flight> flights) {
        int maxOverlap = 0;

        for (int i = 0; i < flights.size(); i++) {
            Flight current = flights.get(i);
            int overlapCount = 1;

            for (int j = 0; j < flights.size(); j++) {
                if (i == j) continue;

                Flight other = flights.get(j);
                if (!(other.getStopUsing().isBefore(current.getStartUsing()) ||
                        other.getStartUsing().isAfter(current.getStopUsing()))) {
                    overlapCount++;
                }
            }

            maxOverlap = Math.max(maxOverlap, overlapCount);
        }

        return maxOverlap;
    }


    private static boolean assignRunwaysBalanced(List<Flight> flights, int numRunways) {
        LocalTime[] runwayFreeAt = new LocalTime[numRunways];
        int[] runwayUsageCount = new int[numRunways];
        Arrays.fill(runwayFreeAt, LocalTime.MIN);

        for (Flight flight : flights) {
            int bestRunway = -1;
            for (int i = 0; i < numRunways; i++) {
                if (runwayFreeAt[i].isBefore(flight.getStartUsing())) {
                    if (bestRunway == -1 || runwayUsageCount[i] < runwayUsageCount[bestRunway])
                    {
                        bestRunway = i;
                    }
                }
            }

            if (bestRunway == -1) {
                return false;
            }

            flight.setRunway(bestRunway);
            runwayFreeAt[bestRunway] = flight.getStopUsing();
            runwayUsageCount[bestRunway]++;
        }

        System.out.println("Zboruri asignate:");
        for (Flight flight : flights) {
            System.out.println("Flight " + flight.getFlightNumber() + " (" +
                    flight.getStartUsing() + " - " + flight.getStopUsing() + ") assigned to runway " + flight.getRunway());
        }
        return true;
    }
}


