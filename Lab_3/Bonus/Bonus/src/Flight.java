import java.time.LocalTime;
import java.util.*;

class Flight {
    private String flightNumber;
    private LocalTime startUsing;
    private LocalTime stopUsing;
    private int runway; // Now using index instead of name

    public Flight(String flightNumber, LocalTime departure, LocalTime arrival) {
        this.flightNumber = flightNumber;
        this.startUsing = departure;
        this.stopUsing = arrival;
    }

    public LocalTime getStartUsing() { return startUsing; }
    public LocalTime getStopUsing() { return stopUsing; }
    public String getFlightNumber() { return flightNumber; }
    public void setRunway(int runway) { this.runway = runway; }
    public int getRunway() { return runway; }

    @Override
    public String toString() {
        return "Flight " + flightNumber + " assigned to Runway " + runway + " from " + startUsing + " to " + stopUsing;
    }
}