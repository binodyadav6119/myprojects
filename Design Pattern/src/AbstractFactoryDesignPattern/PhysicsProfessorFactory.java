package AbstractFactoryDesignPattern;

public class PhysicsProfessorFactory extends ProfessorAbstractFactory{

    @Override
    public Professor createFactory() {
        return new PhysicsProfessor();
    }
}
