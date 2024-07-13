package FactoryDesignPatter;

public class ProfessorClient {
    public static void main(String[] args) {
        Professor professor = ProfessorFactory.getProfessor("MATHS");
        int salary = professor.getSalary();
        System.out.println(salary);

        Professor professor1 = ProfessorFactory.getProfessor("PHYSICS");
        salary= professor1.getSalary();

        System.out.println(salary);


    }
}
