public class Vehicle {

    DriveStrategy driveStrategy;
    Vehicle(DriveStrategy driveStrategy1)
    {
        driveStrategy=driveStrategy1;
    }
    public void drive()
    {
        driveStrategy.drive();
    }
}
