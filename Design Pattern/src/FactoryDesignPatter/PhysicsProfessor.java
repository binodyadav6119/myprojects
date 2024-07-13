package FactoryDesignPatter;

public class PhysicsProfessor implements Professor{

    public int getSalary()
    {
        System.out.println("inside Physics Professor");
        return 40000;
    }
}
