import java.util.Date;

public class UnloadEvent extends DomainEvent {

    public Date date;
    public Cargo cargo;
    public Ship ship;

    public UnloadEvent(Date date, Cargo cargo, Ship ship) {
        super(date);
        this.date = date;
        this.cargo = cargo;
        this.ship = ship;
    }

    @Override
    public void process() {
        ship.unload(this);
    }
}
