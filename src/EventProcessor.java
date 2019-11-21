import java.util.ArrayList;
import java.util.List;

public class EventProcessor {
    List<Event> log = new ArrayList<Event>();

    public void process(Event event) {
        event.process();
        log.add(event);
        System.out.println("event.toString() = " + event.toString());
    }
}
