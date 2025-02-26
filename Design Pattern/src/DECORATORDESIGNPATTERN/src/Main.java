public class Main {
    public static void main(String[] args) {


        BasePizza basePizza = new MushroomTopping( new ExtraCheeseToppings(new MargheritaBasePizza()));
        System.out.println(basePizza.cost());

        System.out.println("Hello world!");
    }
}