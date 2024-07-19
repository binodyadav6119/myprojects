package SingletonPattern;

public class Cat {
    //eager of way if crerating object
    private static Cat cat = new Cat();
    private Cat()
    {

    }
    public static Cat getCatObject()
    {
        return cat;
    }
}
