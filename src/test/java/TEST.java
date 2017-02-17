import UTIL.Records;
import UTIL.Utilites;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TEST {
    Utilites utilites = new Utilites();
///isAbleToAttributeSkillFor()
    @Test  //be different persons
    public void testAbleDiff() throws Exception {

        assertNotEquals("isAbleToAttributeSkillFor it's FUCK; Caused By:",true, utilites.isAbleToAttributeSkillFor( Records.employee3,  Records.employee3,  Records.skill5, Records.skill_set1, Records.skill_set2));
    }

    @Test   //Position
    public void testAblePosition() throws Exception {

        assertNotEquals("isAbleToAttributeSkillFor it's FUCK; Caused By:",true, utilites.isAbleToAttributeSkillFor( Records.employee3,  Records.employee1,  Records.skill5, Records.skill_set1, Records.skill_set2));
    }

    @Test  //same ambient
    public void testAbleAmbient() throws Exception {

        assertNotEquals("isAbleToAttributeSkillFor it's FUCK; Caused By:",true, utilites.isAbleToAttributeSkillFor( Records.employee3,  Records.employee5,  Records.skill5, Records.skill_set1, Records.skill_set2));
    }

    @Test  //higher Skill
    public void testAbleAmbientHigherSkill() throws Exception {

        assertNotEquals("isAbleToAttributeSkillFor it's FUCK; Caused By:",true, utilites.isAbleToAttributeSkillFor( Records.employee2,  Records.employee3,  Records.skill7, Records.skill_set2, Records.skill_set1));
    }

///isSkillWiden(SKILL skill)

    @Test
    public void isSkillWidenT() throws Exception{

        assertEquals("isSkillWiden() it's FUCK; Caused By: ", true, utilites.isSkillWiden(Records.skill16));

    }
    @Test
    public void isSkillWideF() throws Exception{

        assertEquals("isSkillWiden() it's FUCK; Caused By: ", false, utilites.isSkillWiden(Records.skill17));

    }

//isSkillLower(SKILL skill, SKILL_SET skill_set)

    @Test
    public void isSkillLowerT() throws Exception{

        assertEquals("isSkillLower it's FUCK; Caused By:",true, utilites.isSkillLower(Records.skill8, Records.skill_set2));
    }

    @Test
    public void isSkillLowerF() throws Exception{

        assertEquals("isSkillLower it's FUCK; Caused By:",false, utilites.isSkillLower(Records.skill8, Records.skill_set1));
    }

//isSkillParent(SKILL_SET assSkill_set, SKILL_SET emplSkill_set)
    @Test
    public void isSkillParentT() {

       assertEquals("isSkillParent it's FUCK; Caused By:",true,utilites.isSkillParent(Records.skill_set2,Records.skill_set1));

    }

    @Test
    public void isSkillParentF() {

        assertEquals("isSkillParent it's FUCK; Caused By:",false,utilites.isSkillParent(Records.skill_set1,Records.skill_set2));

    }
//lowerSkillAfter(Set<SKILL_SET> input_skill_sets, int daysPassedToLowerOneLevel)

    @Test
    public void isLowerSkillAfter(){
        assertEquals("lowerSkillAfter() it's FUCK; Caused By:",true,utilites.isLowerSkillAfter(Records.skill_sets()));


    }


}

