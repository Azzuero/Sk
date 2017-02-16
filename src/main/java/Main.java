import TRAINING.SKILL_SET;
import UTIL.Records;
import UTIL.Utilites;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {
        //Utilites.isAbleToAttributeSkillFor( Records.employee1,  Records.employee3,  Records.skill7, Records.skill7, Records.skill_set3, Records.skill_set2);

        for (SKILL_SET next: Records.skill_sets()) {
            System.err.println("Current lvl: "+next.getSkillBySkillId().getName());
        }
        System.out.println("=============");
        for (SKILL_SET next: Utilites.daysPassedToLowerOneLevel(Records.skill_sets(),5)) {
            System.err.println("New lvl: "+next.getSkillBySkillId().getName());
        }
    }

}
