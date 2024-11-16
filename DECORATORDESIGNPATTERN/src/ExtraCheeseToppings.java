public class ExtraCheeseToppings extends ToppingDecorator{
    BasePizza basePizza;

    ExtraCheeseToppings(BasePizza basePizza1)
    {
        basePizza=basePizza1;
    }

    @Override
    public int cost() {
        return basePizza.cost()+50;
    }
}
