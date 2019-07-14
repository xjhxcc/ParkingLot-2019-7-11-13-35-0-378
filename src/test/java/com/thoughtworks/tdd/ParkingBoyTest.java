package com.thoughtworks.tdd;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingBoyTest {
    @Test
    public void should_return_ticket_when_call_fetch_given_ticket_from_park(){
        //given
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car fetchCar = parkingBoy.fetch(ticket);
        //then
        Assertions.assertSame(car,fetchCar);

    }
}
