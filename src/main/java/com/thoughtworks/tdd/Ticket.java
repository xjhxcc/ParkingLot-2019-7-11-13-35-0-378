package com.thoughtworks.tdd;

public class Ticket {
    private Car car;

    public Ticket() {
    }

    public Car getCar() {
        return car;
    }

    public Ticket(Car car) {
        this.car = car;
    }
}
