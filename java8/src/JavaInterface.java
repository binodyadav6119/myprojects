interface test
{
    void test();
    default void method1()
    {
        System.out.println("inside method implementation in interface");
    }
}

class test1 implements test{

    @Override
    public void test() {
        System.out.println("testing");
    }
}

public class JavaInterface {
    public static void main(String[] args) {

        test test = new test1();
        test.method1();
        test.test();

        test test1 = new test() {
            @Override
            public void test() {
                System.out.println("anonymous inner class");
            }
        };

        test1.test();

    }
}
