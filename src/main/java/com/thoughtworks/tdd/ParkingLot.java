package com.thoughtworks.tdd;
public class ParkingLot {
    private Car car1;
    private Car car2;
    public Ticket park(Car car) {
        if(car1==null){
            car1=car;
        }else{
            car2=car;
        }
        return new Ticket();
    }

    public Car fetch(Ticket ticket) {
        if(ticket==null){
            return null;
        }
        return ticket.getCar();
//        if(car1!=null){
//            Car tempcar=car1;
//            car1=null;
//            return tempcar;
//        }else{
//            return car2;
//        }
    }
}
