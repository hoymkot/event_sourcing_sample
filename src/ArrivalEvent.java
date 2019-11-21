import java.util.*;

public class ArrivalEvent extends DomainEvent {

    public Date date;
    public Port port;
    public Ship ship;

    public Map<Cargo, Boolean> priorCargoInCanada  = new HashMap<Cargo, Boolean>();

    public ArrivalEvent(Date date, Port port, Ship ship) {
        super(date);
        this.date = date;
        this.port = port;
        this.ship = ship;
    }





    @Override
    public void process() {
        ship.arrive(this);

    }

    @Override
    public void reverse() {

    }
}
