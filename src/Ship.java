import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ship {
    public String name;
    public Port port;
    public List<Cargo> cargo = new ArrayList<Cargo>();

    public static Map<String, Ship> map = new HashMap<String, Ship>();
    public Ship(String name) {
        this.name = name;
        map.put(name, this);


    }

    public void depart(DepartureEvent departureEvent) {

        this.port = new Port("AT SEA");
    }

    public void arrive(ArrivalEvent arrivalEvent) {
        this.port = arrivalEvent.port;
        for (Cargo c : this.cargo) {
            c.arrive(arrivalEvent);
        }
    }

    public void load(LoadEvent loadEvent) {


        this.cargo.add(loadEvent.getCargo());
    }

    public void unload(UnloadEvent unloadEvent) {
        boolean remove = this.cargo.remove(unloadEvent.cargo);
        System.out.println("Ship.unload");
        System.out.println("remove = " + remove);
    }

    public void reverseLoad(LoadEvent loadEvent) {
        boolean remove = this.cargo.remove(loadEvent.getCargo());
        System.out.println("Ship.reverseLoad");
        System.out.println("remove = " + remove);
                
    }
}
