package FactoryDesignPatter;

public class ProfessorFactory {

    public static Professor getProfessor(String professorType)
    {
        if(professorType.equalsIgnoreCase("MATHS"))
        {
            return new MathProfessor();
        }
        else if(professorType.equalsIgnoreCase("PHYSICS"))
        {
            return new PhysicsProfessor();
        }
        else
        {
            return null;
        }
    }
}
