package UTIL;

import TRAINING.EMPLOYEE;
import TRAINING.SKILL;
import TRAINING.SKILL_SET;

import java.util.Date;
import java.util.Set;

public class Utilites {

   public static long toLong(String input){
       return Long.parseLong(input);
   }

   public static int getEmployeeRank(String position){
        int rank=0;
        switch (position) {
            case "JD":
                rank = 1;
                break;
            case "MD":
                rank = 2;
                break;
            case "AD":
                rank = 3;
                break;
            case "SD":
                rank = 4;
                break;
            default:
                rank = 0;
        }
        return rank;
    }

   public static Boolean isSkillWiden(SKILL skill){
        boolean b = false;
        if(skill.getParentId() == 2){

            if (toLong(skill.getName()) <= 6 && toLong(skill.getName()) > 0 )
                b=true;
        }
        else if(skill.getParentId() == 1){
           if (toLong(skill.getName()) <= 3 && toLong(skill.getName()) > 0 )
               b=true;
        }
        else if(skill.getParentId() == 4){
           if (toLong(skill.getName()) <= 3 && toLong(skill.getName()) > 0 )
               b=true;
        }
       return b;
    }

   public static Boolean isSkillLower(SKILL skill, SKILL_SET skill_set){
        boolean b = false;
        if (toLong(skill_set.getSkillBySkillId().getName()) > toLong(skill.getName())) b=true;

        return b;
    }

   public static Boolean isSkillParent(SKILL_SET assSkill_set, SKILL_SET emplSkill_set){
        boolean b = false;
        if(assSkill_set.getSkillBySkillId().getParentId() == emplSkill_set.getSkillBySkillId().getParentId())
            if (toLong(assSkill_set.getSkillBySkillId().getName()) > toLong(emplSkill_set.getSkillBySkillId().getName()))
                b=true;
        return b;
   }






   public static Set<SKILL_SET> lowerSkillAfter(Set<SKILL_SET> input_skill_sets,int daysPassedToLowerOneLevel){

       Set<SKILL_SET> output_skill_sets;

        Date today = new Date(new org.joda.time.DateTime().getYear(), new org.joda.time.DateTime().getMonthOfYear(), new org.joda.time.DateTime().getDayOfMonth());

        for (SKILL_SET next: input_skill_sets) {
            //Date verifycation
            if (next.getAssignedDate().compareTo(today) < 0) {

                long difference = today.getTime() - next.getAssignedDate().getTime();
                long differenceDates = difference / (24 * 60 * 60 * 1000);
                Long skillLvl = differenceDates / daysPassedToLowerOneLevel;

                //Skill Lavel verification
                if(toLong(next.getSkillBySkillId().getName()) == 1){
                    System.out.println("Skill is removed!!!");
                }else if(toLong(next.getSkillBySkillId().getName()) - skillLvl <= 0 ){
                    System.out.println("Does not require changes!!!");
                }else if(toLong(next.getSkillBySkillId().getName()) - skillLvl > 0 ){
                    Long currentLvl = toLong(next.getSkillBySkillId().getName());
                    next.getSkillBySkillId().setName(String.valueOf(currentLvl - skillLvl));
                }
            }
        }

       output_skill_sets = input_skill_sets;
       return output_skill_sets;
    }

    public static boolean isLowerSkillAfter(Set<SKILL_SET> input_skill_set){
       boolean b=true;
       Set<SKILL_SET> temporary_skill_set=lowerSkillAfter(input_skill_set,5);
        for (SKILL_SET next:input_skill_set) {
            for (SKILL_SET next1: temporary_skill_set) {
                if(next.getSkillBySkillId().getName().equals(next1.getSkillBySkillId().getName()))
                    b=false;
            }

        }
       return b;
    }

   public static boolean isAbleToAttributeSkillFor(EMPLOYEE employee, EMPLOYEE assignee, SKILL emplSkill, SKILL_SET emplSkillSet, SKILL_SET assSkillSet){

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
        else if (isSkillWiden(emplSkill) == false){
            System.err.println("ERROR: Skill cannot be widen (not higher in hierarchy of skills)!!!");
            result = false;
        }
        //Lowered
        else if (isSkillLower(emplSkill, emplSkillSet) == false){
            System.err.println("ERROR: Skill cannot be lowered!!!");
            result = false;
        }
        //Parent
        else if (isSkillParent(assSkillSet, emplSkillSet) == false){
            System.err.println("ERROR: Assignee must have higher Skill than employee!!!");
            result = false;
        }

        else{
            System.out.println("Its OK!");
            result = true;
        }
    return  result;
    }
}