package AbstractFactoryDesignPattern;



public class MathsProfessorFactory extends ProfessorAbstractFactory{


    @Override
    public Professor createFactory() {
        return new MathProfessor();
    }
}
