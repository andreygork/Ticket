package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketRepositoryTest {
    private TicketRepository repo = new TicketRepository();

    Ticket first = new Ticket(1, 1000, 60, "AAA", "AAB");
    Ticket second = new Ticket(2, 2500, 100, "AAC", "AAD");
    Ticket third = new Ticket(3, 2000,120, "AAA", "AAB");
    Ticket fourth = new Ticket(4, 1200, 60, "AAE", "AAF");
    Ticket fifth = new Ticket(5, 1500, 90, "AAA", "AAB");


    @Test
    public void ShouldSaveTickets(){
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        Ticket[] expected = new Ticket[] {first, second, third, fourth, fifth};
        Ticket[] actual = repo.FindAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ShouldRemoveById(){
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        repo.RemoveById(2);

        Ticket[] expected = new Ticket[] {first, third, fourth, fifth};
        Ticket[] actual = repo.FindAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void ShouldSaveEmpty(){
        Ticket[] expected = new Ticket[] {};
        Ticket[] actual = repo.FindAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
