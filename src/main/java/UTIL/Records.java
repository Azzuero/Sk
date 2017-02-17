package Util;

import Entity.Employee;
import Entity.Skill;
import Entity.Skill_Set;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Records {
    public static Employee employee1 = new Employee("crm0033", "JAVA", "JD");
    public static Employee employee2 = new Employee("crm0034", "JAVA", "MD");
    public static Employee employee3 = new Employee("crm0035", "JAVA", "SD");
    public static Employee employee4 = new Employee("crm0036", ".NET", "JD");
    public static Employee employee5 = new Employee("crm0037", ".NET", "SD");

    public static Skill skill1 = new Skill(1, "Java", null);
    public static Skill skill2 = new Skill(2, "Italiano", null);
    public static Skill skill3 = new Skill(3, "Spring", 1);
    public static Skill skill4 = new Skill(4, "Bath", 3);
    public static Skill skill5 = new Skill(5, "1", 2);//Italiano
    public static Skill skill6 = new Skill(6, "2", 2);//Italiano
    public static Skill skill7 = new Skill(7, "3", 2);//Italiano
    public static Skill skill8 = new Skill(8, "4", 2);//Italiano
    public static Skill skill9 = new Skill(9, "5", 2);//Italiano
    public static Skill skill10 = new Skill(10, "6", 2);//Italiano
    public static Skill skill11 = new Skill(11, "1", 1);//Java
    public static Skill skill12 = new Skill(12, "2", 1);//Java
    public static Skill skill13 = new Skill(13, "3", 1);//Java
    public static Skill skill14 = new Skill(14, "1", 4);//Bath
    public static Skill skill15 = new Skill(15, "2", 4);//Bath
    public static Skill skill16 = new Skill(16, "3", 4);//Bath
    public static Skill skill17 = new Skill(17, "4", 4);//Bath

    //public static List<SKILL> skillList = new ArrayList<SKILL>();


    public static Skill_Set skill_set1 = new Skill_Set(new Date(2017,02,17), Records.employee1, Records.employee3, Records.skill5 );
    public static Skill_Set skill_set2 = new Skill_Set(new Date(2017,02,17), Records.employee2, Records.employee3, Records.skill10 );
    public static Skill_Set skill_set3 = new Skill_Set(new Date(2017,02,17), Records.employee4, Records.employee3, Records.skill6 );

    public static Set<Skill_Set> skill_sets(){
        Set<Skill_Set> skill_sets = new HashSet<Skill_Set>();
          skill_sets.add(skill_set1);
          skill_sets.add(skill_set2);
          skill_sets.add(skill_set3);
        return skill_sets;
    }


}
