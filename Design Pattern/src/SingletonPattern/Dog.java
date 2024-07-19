package SingletonPattern;

public class Dog {
    private static Dog dog;
    private Dog()
    {
        if(dog!=null)
        {
            throw new RuntimeException("this is singleton pattern");
        }

    }
    //if we create the thread then issue can come. so to handle those cases using synchronise mthod
    public synchronized static Dog getDogObject()
    {

        if(dog==null)
            dog= new Dog();
        return dog;
    }

    public synchronized static Dog getDogObject1()
    {
        //use synchronised block
        synchronized (Dog.class)
        {
            if(dog==null)
                dog= new Dog();
            return dog;
        }

    }
}
