package src.strategy;
public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new OffRoadVehicle();
        vehicle.drive();
        Vehicle vehicle1 = new SportsVehicle();
        vehicle1.drive();
        System.out.println("Hello world!");
    }
}