package AbstractFactoryDesignPattern;

public class ProfessorFactory {

    public static Professor getProfessor(ProfessorAbstractFactory factory)
    {
        return  factory.createFactory();
    }
}
