package Util;

import Entity.Employee;
import Entity.Employee;
import Entity.Skill;
import Entity.Skill_Set;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class Crud {

    public static void isAbleToAttributeSkillFor(Employee employee, Employee assignee,Skill skill){

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<SKILL_SET> skill_setList = session.createQuery("from SKILL_SET ").list();


        if (Utilites.getEmployeeRank(employee.getPosition()) >= Utilites.getEmployeeRank(assignee.getPosition())){
            System.err.println("ERROR: Position of assignee must be greater than position of employee!!!");
        }
        else if (!employee.getAmbient().equals(assignee.getAmbient())){
            System.err.println("ERROR: Assignee and employee must be in the same ambient!!!");
        }
        else if (employee.getCrmd().equals(assignee.getCrmd())){
            System.err.println("ERROR: Assignee and employee should be different persons!!!");
        }


        session.close();
    }
    public static void view() throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();


        List<SKILL_SET> skill_setList = session.createQuery("from SKILL_SET ").list();
        System.out.println("-------- SKILL SET --------");
        for (SKILL_SET next:skill_setList) {
          /*  System.out.println("CRMD: " + next.getEmployeeByCrmd().getCrmd());
            System.out.println("Skill: " + next.getSkillBySkillId().getName());
            System.out.println("AssigneeId: " + next.getAssigneeId());
            System.out.println("AssigneeDate: " + next.getAssignedDate());
            System.out.println("----------------------------");*/

        }

        session.close();
    }
    public static void viewSkill() throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();


        List<SKILL> skilsList = session.createQuery(" from SKILL ").list();
        for (SKILL next:skilsList) {


        }


        session.close();
    }
}
