public class Airliner extends Aircraft implements CargoCapable , PassengerCapable {

    public boolean isCargoCapable() {
        return false;
    }
    public boolean isPassengerCapable() {
        return true;
    }
}
