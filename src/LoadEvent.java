import java.util.Date;

public class LoadEvent extends DomainEvent {

    public Date date;

    String cargo_code;
    String ship_code; // was not on any ship,  going to be loaded on this ship
    public Port prior = null; //  sat on a port, waiting to be load

    public LoadEvent(Date date, Cargo cargo, Ship ship) {
        super(date);
        this.date = date;
        this.cargo_code = cargo.name;
        this.ship_code = ship.name;
    }

    public Ship getShip() {
        return Ship.map.get(this.ship_code);
    }

    public Cargo getCargo() {
        return Cargo.map.get(this.cargo_code);
    }
    @Override
    public void process() {
        getCargo().load(this);
    }
    @Override
    public void reverse() {
        getCargo().reverseLoad(this);
    }
}
