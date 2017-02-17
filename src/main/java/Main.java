import Entity.Skill_Set;
import Util.Records;
import Util.Utilites;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {
        //Utilites.isAbleToAttributeSkillFor( Records.employee1,  Records.employee3,  Records.skill7, Records.skill7, Records.skill_set3, Records.skill_set2);
        System.out.println("=============");
        Utilites.isSkillWiden(Records.skill16);
        System.out.println("=============");
        for (Skill_Set next: Records.skill_sets()) {
            System.out.println("Current lvl: "+next.getSkillBySkillId().getName());
        }
        System.out.println("=============");
       for (Skill_Set next: Utilites.lowerSkillAfter(Records.skill_sets(),5)) {
            System.out.println("New lvl: "+next.getSkillBySkillId().getName());
        }

        System.out.println("islowerSkill: " + Utilites.isLowerSkillAfter(Records.skill_sets()));

    }

}
