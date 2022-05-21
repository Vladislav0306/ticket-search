import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private final TicketRepository repository = new TicketRepository();
    private final Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 95);
    private final Ticket ticket2 = new Ticket(2, 1299, "SVO", "KZN", 95);

    @BeforeEach
    void prepareManager() {
        repository.save(ticket1);
        repository.save(ticket2);
    }

    @Test
    public void shouldSaveOneItem() {
        Ticket[] expected = new Ticket[]{ticket1, ticket2};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(1);
    }

    @Test
    public void findById() {
        repository.findById(1);
        Ticket actual = repository.findById(1);
        assertEquals(ticket1, actual);
    }

    @Test
    public void findByIdNull() {
        repository.findById(10);
        Ticket expected = null;
        Ticket actual = repository.findById(10);
        assertEquals(expected, actual);
    }
}