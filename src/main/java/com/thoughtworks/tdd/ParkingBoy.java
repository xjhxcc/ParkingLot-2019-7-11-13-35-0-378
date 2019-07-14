package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot=parkingLot;
        parkingLots=new ArrayList<>();
    }
    public Ticket park(Car car) {
        Ticket ticket=parkingLot.park(car);
        //从ParkinLot返回
        if(ticket==null){
            for(int i=0;i<parkingLots.size();i++){
                ticket=parkingLots.get(i).park(car);
                if(ticket!=null){
                    return ticket;
                }
            }
        }
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        return parkingLot.fetch(ticket);
    }

    public ParkingLot getParkingLotIndex (int i) {
        if (i == 0) {
            return parkingLot;
        }
        else  {
            return parkingLots.get(i - 1);
        }
    }

    public void addParkingLot () {
        parkingLots.add(new ParkingLot());
    }
}
