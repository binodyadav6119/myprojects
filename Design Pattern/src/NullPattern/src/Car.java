public class Car implements Vehicle{

    @Override
    public int getTankCapacity() {
        System.out.println("Inside get tank capacity");
        return 20;
    }

    @Override
    public int getSeatCapacity() {
        System.out.println("Inside get seat capacity");

        return 30;
    }
}
