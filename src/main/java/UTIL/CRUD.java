package UTIL;

import TRAINING.EMPLOYEE;
import TRAINING.SKILL_SET;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class CRUD {

    public static void view() throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();


        List<SKILL_SET> skill_setList = session.createQuery("from SKILL_SET ").list();
        System.out.println("-------- SKILL SET --------");
        for (SKILL_SET next:skill_setList) {
            System.out.println("AssigneeId: " + next.getAssigneeId());
            System.out.println("AssigneeDate: " + next.getAssignedDate());
            System.out.println("CRMD: " + next.getEmployeeByCrmd().getCrmd());
            System.out.println("Skill: " + next.getSkillBySkillId().getName());

        }
        System.out.println("----------------------------");

        session.close();
    }
    public static void viewEmpl() throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();


        List<EMPLOYEE> employeestList = session.createQuery(" from EMPLOYEE ").list();
        System.out.println("-------- EMPLOYEE --------");
        for (EMPLOYEE next:employeestList) {
            System.out.println("CRM: " + next.getCrmd());
            System.out.println("Ambient: " + next.getAmbient());
            System.out.println("Position: " + next.getPosition());

        }
        System.out.println("----------------------------");

        session.close();
    }
}
