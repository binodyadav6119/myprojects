public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicleObject("bike");

        System.out.println(vehicle.getSeatCapacity());
        System.out.println(vehicle.getTankCapacity());
    }
}