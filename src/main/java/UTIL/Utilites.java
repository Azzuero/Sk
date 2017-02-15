package UTIL;

import TRAINING.EMPLOYEE;
import TRAINING.SKILL;
import TRAINING.SKILL_SET;

import java.sql.Date;
import java.util.Set;

public class Utilites {

    public static int getEmployeeRank(String position){
        int rank=0;
        if (position.equals("JD")) {
            rank = 1;

        } else if(position.equals("MD")) {
            rank = 2;
        }
        else if(position.equals("AD")) {
            rank = 3;
        }
        else if(position.equals("SD")) {
            rank = 4;
        }
        return rank;
    }

   public static Boolean verifySkillWiden(SKILL skill){
        boolean b = false;
        if(skill.getParentId() == 2){
            if (Long.parseLong(skill.getName()) <6 ){
                b=true;
            }
        }else if(skill.getParentId() == 1){
           if (Long.parseLong(skill.getName()) < 3 ){
               b=true;
           }
       }

       return b;
    }
    public static Boolean verifySkillLower(SKILL skill, SKILL_SET skill_set,String crmd){
        boolean b = true;
       // if(skill_set.getEmployeeByCrmd().equals(crmd)){
            if (Long.parseLong(skill_set.getSkillBySkillId().getName()) > Long.parseLong(skill.getName())){
                b=false;
            }
        //}
        return b;
    }

    public static Boolean verifySkillParent(SKILL_SET assSkill_set, SKILL_SET emplSkill_set){
            boolean b = false;
        if(assSkill_set.getSkillBySkillId().getParentId() == emplSkill_set.getSkillBySkillId().getParentId()){
            if (Long.parseLong(assSkill_set.getSkillBySkillId().getName()) > Long.parseLong(emplSkill_set.getSkillBySkillId().getName())){
                b=true;
            }
        }
        return b;
    }
        public static Boolean lowerSkillAfter(Date date, Set<SKILL_SET> skill_sets){
            boolean b = false;
            for (SKILL_SET next: skill_sets) {
                if (date.compareTo(next.getAssignedDate()) > 0){
                    b = true;
                }
        }

        return b;
    }
    public static boolean isAbleToAttributeSkillFor(EMPLOYEE employee, EMPLOYEE assignee, SKILL emplSkill, SKILL assSkill, SKILL_SET emplSkillSet, SKILL_SET assSkillSet){

        boolean result = true;

        //different persons
        if (employee.getCrmd().equals(assignee.getCrmd())){
            System.err.println("ERROR: Assignee and employee should be different persons!!!");
            result = false;
        }
        //Position
        else if (getEmployeeRank(employee.getPosition()) >= getEmployeeRank(assignee.getPosition())){
            System.err.println("ERROR: Position of assignee must be greater than position of employee!!!");
            result = false;
        }
        //Ambient
        else if (!employee.getAmbient().equals(assignee.getAmbient())){
            System.err.println("ERROR: Assignee and employee must be in the same ambient!!!");
            result = false;
        }
        //Skill
        else if (verifySkillWiden(emplSkill) == false){
            System.err.println("ERROR: Skill cannot be widen (not higher in hierarchy of skills)!!!");
            result = false;
        }
        //Lowered
        else if (verifySkillLower(emplSkill, emplSkillSet, employee.getCrmd()) == false){
            System.err.println("ERROR: Skill cannot be lowered!!!");
            result = false;
        }
        //Parent
        else if (verifySkillParent(assSkillSet, emplSkillSet) == false){
            System.err.println("ERROR: Assignee must have higher Skill than employee!!!");
            result = false;
        }
        //Date
        else if (lowerSkillAfter(emplSkillSet.getAssignedDate(), Records.skill_sets()) == false){
            System.err.println("ERROR: Incorect Date!!!");
            result = false;
        }

        else{
            System.out.println("Its OK!");
            result = true;
        }
    return  result;
    }
}
