import java.util.Date;

public class DepartureEvent extends DomainEvent{

    public Date date;
    public Port port;
    public Ship ship;

    public DepartureEvent(Date date, Port port, Ship ship) {
        super(date);
        this.date = date;
        this.port = port;
        this.ship = ship;
    }

    @Override
    public void process() {
        ship.depart(this);

    }
}
