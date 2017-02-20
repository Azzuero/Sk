package Util;
import Entity.Employee;
import Entity.Skill;
import Entity.Skill_Set;
import com.vaadin.ui.ComboBox;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.*;

public class Crud {

    public static ComboBox getEmployee() {
        ComboBox temporaryCombobox = new ComboBox("CRMD");
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Employee> listEmployee = session.createCriteria(Employee.class).list();
        for (Employee next : listEmployee) {
            temporaryCombobox.addItem(next.getCrmd());
        }

        session.close();
        return temporaryCombobox;
    }
   /* public static ComboBox getSkill(){
        ComboBox temporaryCombobox = new ComboBox("Skill");
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Skill> listEmployee = session.createCriteria(Skill.class).list();
        for (Skill next:listEmployee ) {
            temporaryCombobox.addItem(next.getName());
        }

        session.close();
        return temporaryCombobox;
    }*/

    public static ComboBox getSkill() {
        ComboBox temporaryCombobox = new ComboBox("Skill");
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Skill_Set> listEmployee = session.createCriteria(Skill_Set.class).list();
        for (Skill_Set next : listEmployee) {
            temporaryCombobox.addItem(next.getAssignedDate());
        }

        session.close();
        return temporaryCombobox;
    }

    public static void view() throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();


        List<Skill_Set> skill_setList = session.createQuery("from SKILL_SET ").list();
        System.out.println("-------- SKILL SET --------");
        for (Skill_Set next : skill_setList) {
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


        List<Skill> skilsList = session.createQuery(" from SKILL ").list();
        for (Skill next : skilsList) {


        }


        session.close();
    }

    public static List<Employee> getAssignee(String CRMD) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Employee where CRMD =:a");
        query.setParameter("a", CRMD);
        List<Employee> getemployeebycrmd = query.list();
        List<Employee> getallemployee = session.createQuery("from Employee").list();
        List<Employee> employees = new ArrayList<Employee>(0);
        for (Employee next : getemployeebycrmd) {
            for (Employee next1 : getallemployee) {
                if (Utilites.getEmployeeRank(next.getPosition()) < Utilites.getEmployeeRank(next1.getPosition()))
                    employees.add(next1);
                else if (Utilites.getEmployeeRank(next.getPosition()) == 4 && Utilites.getEmployeeRank(next1.getPosition()) == 4)
                    if (!next.getCrmd().equals(next1.getCrmd()))
                        employees.add(next1);
            }
        }
        session.close();
        return employees;
    }


    public static List<String> getSkill1() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Skill> skills = session.createQuery("from Skill").list();
        List<Skill> skills1 = session.createQuery("from Skill").list();
        Collection<Map<String, ?>> collection = new ArrayList<Map<String, ?>>();
        for (Skill next : skills) {
            for (Skill next1 : skills1) {
                Map<String, Object> map = new HashMap<String, Object>();
                if (next.getParentId() != null && next1.getParentId() != null)
                    if (next.getId() == next1.getParentId()) {
                        map.put("Name", next.getName());
                        map.put("Value", next1.getName());
                        collection.add(map);
                    }

            }
        }
        List<String> listString = new ArrayList<String>(0);
        for (Map<String, ?> next12 : collection) {
            String temp = "";
            temp = String.valueOf(next12.get("Name")) + String.valueOf(next12.get("Value"));
            listString.add(temp);
            System.out.println(temp);
        }
        return listString;
    }
}


