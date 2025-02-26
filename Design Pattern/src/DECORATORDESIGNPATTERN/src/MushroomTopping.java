public class MushroomTopping extends ToppingDecorator{
    BasePizza basePizza;

    MushroomTopping(BasePizza basePizza1)
    {
        basePizza=basePizza1;
    }

    @Override
    public int cost() {
        return basePizza.cost()+100;
    }
}
