import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;

public class TicketManager {
    TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAllByPrice(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (ticket.getDepartureAirport().equalsIgnoreCase(from) && ticket.getArrivalAirport().equalsIgnoreCase(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findAllByTime(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (ticket.getDepartureAirport().equalsIgnoreCase(from) && ticket.getArrivalAirport().equalsIgnoreCase(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}
