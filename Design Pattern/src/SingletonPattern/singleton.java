package SingletonPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static SingletonPattern.Dog.getDogObject;

public class singleton {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Dog dog1 = Dog.getDogObject1();
        Dog dog2 = Dog.getDogObject1();

        System.out.println(dog1.hashCode());
        System.out.println(dog2.hashCode());

        Cat cat1=Cat.getCatObject();
        Cat cat2=Cat.getCatObject();
        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());

        //breaking singleton pattern
        Constructor<Dog> constructor = Dog.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Dog dog = constructor.newInstance();
        System.out.println(dog.hashCode());

        //ways to get prevented from this



    }
}
