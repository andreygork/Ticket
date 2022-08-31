package ru.netology.domain;

import ru.netology.manager.TicketManager;

public class Ticket implements Comparable <Ticket> {
    private int id;
    private int price;
    private int travelTime;

    protected String from;
    protected String to;

    public Ticket(int id, int price, int travelTime, String from, String to) {
        this.id = id;
        this.price = price;
        this.travelTime = travelTime;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public int compareTo(Ticket o) {
        if (price < o.price) {
            return -1;
        }
        if (price > o.price){
            return 1;
        }else {
            return 0;
        }
    }
}
