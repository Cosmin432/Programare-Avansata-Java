public class Problem {
    public static void main(String[] args) {

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



}
}