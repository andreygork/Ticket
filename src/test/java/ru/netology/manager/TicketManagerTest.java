package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    private TicketRepository repo = new TicketRepository();
    private TicketManager manager = new TicketManager(repo);

    Ticket first = new Ticket(1, 1000, 60, "AAA", "AAB");
    Ticket second = new Ticket(2, 2500, 100, "AAC", "AAD");
    Ticket third = new Ticket(3, 2000, 120, "AAA", "AAB");
    Ticket fourth = new Ticket(4, 1200, 60, "AAE", "AAF");
    Ticket fifth = new Ticket(5, 1500, 90, "AAA", "AAB");
    Ticket sixth = new Ticket(6, 2000, 130, "AAA", "AAB");
    Ticket seventh = new Ticket(7, 2600, 140, "AAA", "AAN");


    @BeforeEach
    public void setup() {
        manager.addTicket(first);
        manager.addTicket(second);
        manager.addTicket(third);
        manager.addTicket(fourth);
        manager.addTicket(fifth);
        manager.addTicket(sixth);
        manager.addTicket(seventh);

    }

    @Test
    public void ShouldSearchCheapTickets() {
        Ticket[] expected = new Ticket[]{first, fifth, third, sixth};
        Ticket[] actual = manager.searchBy("AAA", "AAB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchInvalidCheapTickets() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchBy("BAA", "BBB");
        Assertions.assertArrayEquals(expected, actual);
    }
}

