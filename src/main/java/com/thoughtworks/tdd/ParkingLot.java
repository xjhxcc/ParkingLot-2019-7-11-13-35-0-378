package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Ticket> tickets;
    public ParkingLot() {
        tickets=new ArrayList<>();
    }

    public Ticket park(Car car) {
        Ticket ticket=new Ticket(car);
        tickets.add(ticket);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if(ticket==null){
            return null;
        }
        Car result = ticket.getCar();
        //pakingLot中存tickets,Ticket中可以得到对应的车，取完车之后根据票将车设置为null
        ticket.setCar(null);
        return result;
    }
}
