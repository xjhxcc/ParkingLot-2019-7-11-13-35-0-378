package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Ticket> tickets;
    public ParkingLot() {
        tickets=new ArrayList<>();
    }

    public Ticket park(Car car) {
        if(tickets.size()>=10){
            return null;
        }
        Ticket ticket=new Ticket(car);
        tickets.add(ticket);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car result=null;
        if(ticket==null){
            result= null;
        }
        result = ticket.getCar();
        //pakingLot中存tickets,Ticket中可以得到对应的车，取完车之后根据票将车设置为null
        ticket.setCar(null);
        if(result==null){
            System.out.print("Unrecognized parking ticket.");
        }
        return result;
    }
}
