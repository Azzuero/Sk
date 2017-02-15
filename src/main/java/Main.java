import UTIL.Records;
import UTIL.Utilites;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {

        Utilites.isAbleToAttributeSkillFor( Records.employee1,  Records.employee3,  Records.skill7, Records.skill7, Records.skill_set3, Records.skill_set2);

    }

}
