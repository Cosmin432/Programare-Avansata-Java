
public class Freighter extends Aircraft implements CargoCapable , PassengerCapable {

    public boolean isCargoCapable() {
        return true;
    }

    public boolean isPassengerCapable() {
        return false;
    }
}
