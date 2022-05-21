import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketManager manager;
    private final Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 100);
    private final Ticket ticket2 = new Ticket(2, 2199, "DME", "KZN", 95);
    private final Ticket ticket3 = new Ticket(3, 1000, "SVO", "KZN", 95);

    @BeforeEach
    public void setUp() {
        manager = new TicketManager(new TicketRepository());
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
    }

    @Test
    void mustSearchIfExists() {
        Ticket[] expected = {ticket1, ticket2};
        assertArrayEquals(expected, manager.findAllByPrice("DME", "KZN"));
    }

    @Test
    void mustSearchIfNotExists() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAllByPrice("AAA", "AAJ"));
    }

    @Test
    void mustSearchIfExistsTo() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAllByPrice("DME", null));
    }

    @Test
    void mustShowTicketByPrice() {
        Comparator<Ticket> comparator = new TicketByTimeAscComparator();
        Ticket[] expected = {ticket2, ticket1};
        assertArrayEquals(expected, manager.findAllByTime("DME", "KZN", comparator));
    }

    @Test
    void mustShowNoTicketByPrice() {
        Comparator<Ticket> comparator = new TicketByTimeAscComparator();
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAllByTime("AAA", "AAJ", comparator));
    }

    @Test
    void mustShowNullTicketByPrice() {
        Comparator<Ticket> comparator = new TicketByTimeAscComparator();
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAllByTime("DME", null, comparator));
    }
}