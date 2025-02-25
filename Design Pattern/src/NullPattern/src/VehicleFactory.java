public class VehicleFactory {

    static Vehicle getVehicleObject(String type)
    {
        if("car".equalsIgnoreCase(type))
        {
            return new Car();
        }
        return new NullVehicle();
    }
}
