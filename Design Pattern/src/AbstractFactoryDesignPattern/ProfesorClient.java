package AbstractFactoryDesignPattern;

public class ProfesorClient {

    public static void main(String[] args) {

        Professor professor = ProfessorFactory.getProfessor(new MathsProfessorFactory());
        System.out.println(professor.getSalary());


        Professor professor1 = ProfessorFactory.getProfessor(new PhysicsProfessorFactory());
        System.out.println(professor1.getSalary());
    }
}
