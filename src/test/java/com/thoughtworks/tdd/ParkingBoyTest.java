package com.thoughtworks.tdd;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingBoyTest {
    @Test
    public void should_return_car_when_call_fetch_given_ticket_from_park(){
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
    @Test
    public void should_return_cars_when_call_fetch_car_given_tickets_by_parking_car(){
        //given
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        //when
        Car fetchCar1 = parkingBoy.fetch(ticket1);
        Car fetchCar2 = parkingBoy.fetch(ticket2);
        //then
        Assertions.assertSame(car1,fetchCar1);
        Assertions.assertSame(car2,fetchCar2);
    }
}
