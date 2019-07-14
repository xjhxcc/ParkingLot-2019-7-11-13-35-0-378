package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class SmartPakingBoy {
    private List<ParkingLot> parkingLots;
    public SmartPakingBoy(ParkingLot parkingLot) {
        parkingLots=new ArrayList<>();
        parkingLots.add(parkingLot);
    }
    public Ticket park(Car car) {
        int index = 0;
        for (int i = 0; i < parkingLots.size(); i++) {
            if (parkingLots.get(i).getTickets().size() < parkingLots.get(index).getTickets().size()) {
                index = i;
            }
        }
        return parkingLots.get(index).park(car);
    }
    public ParkingLot getParkingLotIndex (int index) {
        return parkingLots.get(index);
    }

    public void addParkingLot () {
        parkingLots.add(new ParkingLot());
    }
}
