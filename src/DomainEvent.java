import java.util.Date;

public abstract  class DomainEvent implements Event {
    public Date recorded;
    public Date occurred;

    public DomainEvent(Date occurred) {
        this.occurred = occurred;
        this.recorded = new Date();
    }

    public abstract void process();
    public abstract void reverse();
}
