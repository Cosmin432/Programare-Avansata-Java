import java.time.LocalTime;

class Flight {
    private String flightNumber;

    private Aircraft aircraft;
    private LocalTime departure;
    private LocalTime arrival;

    private String runway;

    public Flight(String flightNumber, LocalTime departure, LocalTime arrival, Aircraft aircraft) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.aircraft=aircraft;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + " landing between " + departure + " and " + arrival;
    }
    public void setRunway(String runway) {
        this.runway = runway;
    }
    public String getRunway() {
        return runway;
    }

    public LocalTime getDeparture() {
        return departure;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
}