import java.time.LocalTime;
import java.util.ArrayList;

public class Problem {
    public static void main(String[] args) {
        //Aircraft init
        Aircraft[] aircrafts = new Aircraft[3];

        Drone drone = new Drone();
        Airliner airliner = new Airliner();
        Freighter freighter = new Freighter();

        drone.setName("Dronozaur");
        airliner.setName("Airliner1");
        freighter.setName("Freighter1");

        aircrafts[0] = drone;
        aircrafts[1] = airliner;
        aircrafts[2] = freighter;
        //Airport init
        Airport cotu = new Airport("Cotu");
        cotu.addRunway("Nucilor");
        cotu.addRunway("Salcamilor");
        ArrayList<String> runways = cotu.getRunways();

        //Flights init
        Flight[] flights = new Flight[3];

        LocalTime departure = LocalTime.of(8, 0);
        LocalTime arrival = LocalTime.of(10, 0);
        Flight flight1 = new Flight("111ABC", departure, arrival, airliner);
        flights[0] = flight1;


        departure = LocalTime.of(9, 0);
        arrival = LocalTime.of(13, 0);
        Flight flight2 = new Flight("111DEF", departure, arrival, drone);
        flights[1] = flight2;

        departure = LocalTime.of(9, 00);
        arrival = LocalTime.of(14, 0);
        Flight flight3 = new Flight("111GHI", departure, arrival, drone);
        flights[2] = flight3;

        for (Flight flight : flights) {
            for (String runway : runways) {
                boolean isRunwayAvailable = true;

                // Check if the runway is already in use at the same departure time
                for (Flight otherFlight : flights) {

                  if(otherFlight.getRunway()!=null&& otherFlight.getRunway().equals(runway)&&otherFlight.getDeparture().equals(flight.getDeparture())) {
                      isRunwayAvailable = false;
                      break;
                  }
                }

                if (isRunwayAvailable) {
                    flight.setRunway(runway);
                    System.out.println("Flight " + flight.getFlightNumber() + " assigned to runway " + runway);
                    break;
                }
            }
        }
    }
}