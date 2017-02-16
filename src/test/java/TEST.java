import UTIL.Records;
import UTIL.Utilites;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TEST {
    Utilites utilites = new Utilites();

    @Test
    public void testAble() throws Exception {


        assertEquals("isAbleToAttributeSkillFor it's FUCK; Caused By:",false, utilites.isAbleToAttributeSkillFor( Records.employee1,  Records.employee3,  Records.skill7, Records.skill7, Records.skill_set1, Records.skill_set2));
    }

    @Test
    public void employeeRank() throws Exception{


        assertEquals("getEmployeerank it's FUCK; Caused By:",3, utilites.getEmployeeRank(Records.employee3.getPosition()));
    }

    @Test
    public void lowerSkillAfter() {

       assertEquals("lowerSkillAfter it's FUCK; Caused By:",true,utilites.isLowerSkillAfter(Records.skill_set3.getAssignedDate(), Records.skill_sets()));

    }
}

