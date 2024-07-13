package FactoryDesignPatter;

public class MathProfessor implements  Professor{

    public int getSalary()
    {
        System.out.println("inside Math Professor");
        return 50000;
    }
}
