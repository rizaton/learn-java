package coding.rizaton.application;

import coding.rizaton.data.Avanza;
import coding.rizaton.data.Bus;
import coding.rizaton.data.Car;

public class CarApp {
    public static void main(String[] args) {
        Car car = new Avanza();
        System.out.println(car.getTire());
        car.drive();
        System.out.println(car.isBig());

        Bus  bus = new Bus();
        System.out.println(bus.getTire());
        bus.drive();
        System.out.println(bus.isBig());
    }
}