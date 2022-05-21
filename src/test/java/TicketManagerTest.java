import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketManager manager;
    private final Ticket ticket1 = new Ticket(1, 2199, "DME", "KZN", 95);
    private final Ticket ticket2 = new Ticket(2, 1299, "DME", "KZN", 95);
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
        Ticket[] expected = {ticket2, ticket1};
        assertArrayEquals(expected, manager.findAll("DME", "KZN"));
    }

    @Test
    void mustSearchIfNotExists() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAll("AAA", "AAJ"));
    }

    @Test
    void mustSearchIfExistsTo() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAll("DME", null));
    }
}