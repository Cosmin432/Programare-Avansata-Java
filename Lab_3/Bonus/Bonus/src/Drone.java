public class Drone extends Aircraft implements PassengerCapable , CargoCapable {

    public boolean isPassengerCapable() {
        return false;
    }

    public boolean isCargoCapable() {
        return false;
    }
}
