import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventSourceBox {
    public static void main(String[] args) throws ParseException {
        Ship kr;
        Port sfo, la, yyv;
        Cargo refact;
        EventProcessor eProc;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        eProc = new EventProcessor();
        refact = new Cargo ("Refactoring");
        kr = new Ship("King Roy");
        sfo = new Port("San Francisco", "US");
        la = new Port("Los Angeles", "US");
        yyv = new Port("Vancouver", "CANADA") ;

        eProc.process(new LoadEvent(df.parse("2005-11-1"), refact, kr));
        eProc.process(new ArrivalEvent(df.parse("2005-11-2"), yyv, kr));
        eProc.process(new DepartureEvent(df.parse("2005-11-3"), yyv, kr ));
        eProc.process(new ArrivalEvent(df.parse("2005-11-4"), sfo, kr));
        eProc.process(new UnloadEvent(df.parse("2005-11-5"), refact, kr));
        System.out.println(refact.hasBeenInCanada);

    }

    static public void backlog() {
//        ArrivalEvent ev = new ArrivalEvent(df.parse("2005-11-11"), sfo, kr);
//        eProc.process(ev);
//
//        System.out.println(sfo.name);
//        System.out.println(kr.port.name);
//
//
//        System.out.println("");
//        eProc.process(new ArrivalEvent(df.parse("2005-10-1"), la, kr));
//        eProc.process(new ArrivalEvent(df.parse("2005-11-1"), sfo, kr));
//        eProc.process(new DepartureEvent(df.parse("2005-11-1"), sfo, kr));
//
//        System.out.println("AT_SEA");
//        System.out.println(kr.port.name);
    }
}
