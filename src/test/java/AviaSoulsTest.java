import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("Москва", "Пекин", 10_000, 23, 5);
    Ticket ticket2 = new Ticket("Москва", "Пекин", 23_000, 2, 7);
    Ticket ticket3 = new Ticket("Москва", "Пекин", 15_000, 5, 19);
    Ticket ticket4 = new Ticket("Москва", "Пекин", 13_000, 16, 22);
    Ticket ticket5 = new Ticket("Лондон", "Париж", 21_000, 3, 8);
    Ticket ticket6 = new Ticket("Лондон", "Париж", 32_000, 7, 12);
    Ticket ticket7 = new Ticket("Лондон", "Париж", 9_000, 11, 16);
    Ticket ticket8 = new Ticket("Гонконг", "Токио", 54_000, 3, 7);
    Ticket ticket9 = new Ticket("Гонконг", "Токио", 76_000, 6, 13);
    Ticket ticket10 = new Ticket("Гонконг", "Париж", 45_000, 11, 21);
    Ticket ticket11 = new Ticket("Москва", "Пекин", 10_000, 11, 21);

    @Test
    public void testSortTicketForMoreThenOneResult() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);

        Ticket[] actual = manager.search("Москва", "Пекин");
        Ticket[] expected = {ticket1, ticket11, ticket4, ticket3, ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketForOneResult() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);

        Ticket[] actual = manager.search("Гонконг", "Париж");
        Ticket[] expected = {ticket10};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketForZeroResult() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);

        Ticket[] actual = manager.search("Гонконг", "Лондон");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketForMoreThenOneResultWithComparator() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Москва", "Пекин", comparator);
        Ticket[] expected = {ticket2, ticket1, ticket4, ticket11, ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketForOneResultWithComparator() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Гонконг", "Париж", comparator);
        Ticket[] expected = {ticket10};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketForZeroResultWithComparator() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Гонконг", "Лондон", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}
