import java.util.HashMap;
import java.util.Map;

public class Cargo {
    public String name;
    public Port port;
    public Ship ship;


    public static Map<String, Cargo> map = new HashMap<String, Cargo>();
    public Cargo(String name) {
        this.name = name;
        map.put(name, this);
    }
    public Boolean hasBeenInCanada = false;
    public void arrive(ArrivalEvent arrivalEvent) {
        arrivalEvent.priorCargoInCanada.put(this, this.hasBeenInCanada);
        if (arrivalEvent.port.country.equals("CANADA")) {
            this.hasBeenInCanada = true;
        }

    }

    public void reverseArrival(ArrivalEvent arrivalEvent) {
        this.hasBeenInCanada =  arrivalEvent.priorCargoInCanada.get(this);
    }

    public void load(LoadEvent loadEvent) {
        loadEvent.prior = this.port;
        port = null; // no longer in a port
        ship = loadEvent.getShip(); // was not on any ship, sat on a port
        ship.load(loadEvent);
    }

    public void reverseLoad(LoadEvent loadEvent) {
        this.port = loadEvent.prior;
        this.ship = null;
        ship.reverseLoad(loadEvent);
    }


}
