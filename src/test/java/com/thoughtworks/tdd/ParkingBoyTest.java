package com.thoughtworks.tdd;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


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
    @Test
    public void should_return_null_when_call_fetch_given_wrong_ticket () {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car actual = parkingBoy.fetch(new Ticket());
        //then
        Assertions.assertNull(actual);
    }
    @Test
    public void should_return_null_when_call_fetch_given_ticket_have_been_used () {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(ticket);
        Car actual = parkingBoy.fetch(ticket);
        //then
        Assertions.assertNull(actual);

    }
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public ParkingBoyTest () {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }
    @Test
    public void should_return_null_and_print_reason_when_call_fetch_given_wrong_ticket ()  {
        should_return_null_when_call_fetch_given_wrong_ticket();
        Assertions.assertTrue(systemOut().endsWith("Unrecognized parking ticket."));
    }
    @Test
    public void should_return_null_and_print_reason_when_call_fetch_given_ticket_have_been_used () {
        should_return_null_when_call_fetch_given_ticket_have_been_used();
        Assertions.assertTrue(systemOut().endsWith("Unrecognized parking ticket."));
    }
    @Test
    public void should_return_null_and_print_when_call_fetch_given_no_ticket () {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car actual = parkingBoy.fetch(null);
        //then
        Assertions.assertNull(actual);
        Assertions.assertTrue(systemOut().endsWith("Please provide your parking ticket."));
    }
    @Test
    public void should_return_null_and_print_when_call_park_given_pakingLot_greater_than_or_equal_to_10 () {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i=0;i<10;i++){
            Ticket ticket = parkingBoy.park(new Car());
        }
        //when
        Ticket ticket=parkingBoy.park(new Car());
        //then
        Assertions.assertNull(ticket);
        Assertions.assertTrue(systemOut().endsWith("Not enough position."));

    }
    @Test
    public void should_return_park_in_more_parkingLot_when_call_park_in_second_parkingLot_given_first_parkingLot_full(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i=0;i<10;i++){
           parkingBoy.park(new Car());
        }
        parkingBoy.addParkingLot();
        //when
        for(int i=0;i<2;i++){
            parkingBoy.park(new Car());
        }
        //then
        assertThat(parkingBoy.getParkingLotIndex(0).getTickets().size(),is(10));
        assertThat(parkingBoy.getParkingLotIndex(1).getTickets().size(),is(2));
    }
    @Test
    public void should_return__park_in_more_parkingLot_when_call_park_given_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartPakingBoy smartPakingBoy = new SmartPakingBoy(parkingLot);
        //when
        smartPakingBoy.park(new Car());
        smartPakingBoy.addParkingLot();
        smartPakingBoy.park(new Car());
        //then
        assertThat(smartPakingBoy.getParkingLotIndex(0).getTickets().size(),is(1));
        assertThat(smartPakingBoy.getParkingLotIndex(1).getTickets().size(),is(1));


    }
}
