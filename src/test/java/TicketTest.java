import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    @Test
    void setId() {
        Ticket ticket = new Ticket();
        ticket.setId(1);
        int expected = 1;
        int actual = ticket.getId();
        assertEquals(expected, actual);
    }

    @Test
    void setPrice() {
        Ticket ticket = new Ticket();
        ticket.setPrice(1299);
        int expected = 1299;
        int actual = ticket.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    void setTravelTime() {
        Ticket ticket = new Ticket();
        ticket.setTravelTime(95);
        int expected = 95;
        int actual = ticket.getTravelTime();
        assertEquals(expected, actual);
    }

    @Test
    void setDepartureAirport() {
        Ticket ticket = new Ticket();
        ticket.setDepartureAirport("DME");
        String expected = "DME";
        String actual = ticket.getDepartureAirport();
        assertEquals(expected, actual);
    }

    @Test
    void setArrivalAirport() {
        Ticket ticket = new Ticket();
        ticket.setArrivalAirport("KZN");
        String expected = "KZN";
        String actual = ticket.getArrivalAirport();
        assertEquals(expected, actual);
    }

    @Test
    void equals1() {
        Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 95);
        Ticket ticket2 = new Ticket(ticket1.getId(), ticket1.getPrice(), ticket1.getDepartureAirport(), ticket1.getArrivalAirport(), ticket1.getTravelTime());
        assertEquals(ticket1, ticket2);
    }

    @Test
    void equals2() {
        Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 95);
        Ticket ticket2 = new Ticket();
        assertNotEquals(ticket1, ticket2);
    }

    @Test
    void equals3() {
        Ticket ticket = new Ticket(1, 1299, "DME", "KZN", 95);
        Object o = null;
        assertNotEquals(ticket, o);
    }

    @Test
    void equals4() {
        Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 95);
        Ticket ticket2 = new Ticket(ticket1.getTravelTime(), ticket1.getId(), ticket1.getArrivalAirport(), ticket1.getDepartureAirport(), ticket1.getPrice());
        assertNotEquals(ticket1, ticket2);
    }

    @Test
    void equals5() {
        Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 95);
        Ticket ticket2 = new Ticket(2, 2199, "KZN", "DME", 100);
        assertNotEquals(ticket1, ticket2);
    }

    @Test
    void equals6() {
        Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 95);
        Ticket ticket2 = new Ticket(1, 2199, "KZN", "DME", 100);
        assertNotEquals(ticket1, ticket2);
    }

    @Test
    void equals7() {
        Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 95);
        Ticket ticket2 = new Ticket(ticket1.getId(), ticket1.getPrice(), ticket1.getArrivalAirport(), ticket1.getDepartureAirport(), ticket1.getTravelTime());
        assertNotEquals(ticket1, ticket2);
    }

    @Test
    void equals8() {
        Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 95);
        Ticket ticket2 = new Ticket(1, 1299, "KZN", "DME", 100);
        assertNotEquals(ticket1, ticket2);
    }

    @Test
    void equals9() {
        Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 95);
        Ticket ticket2 = new Ticket(1, 1299, "DME", "AAJ", 95);
        assertNotEquals(ticket1, ticket2);
    }

    @Test
    void toString1() {
        Ticket ticket = new Ticket(1, 1299, "DME", "KZN", 95);
        String string = ticket.toString();
        assertNotEquals(ticket, string);
    }

    @Test
    void hashCode1() {
        Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 95);
        Ticket ticket2 = new Ticket(ticket1.getId(), ticket1.getPrice(), ticket1.getDepartureAirport(), ticket1.getArrivalAirport(), ticket1.getTravelTime());
        assertEquals(ticket1.hashCode(), ticket2.hashCode());
    }
}