package TRAINING;

import java.sql.Date;


public class SKILL_SET {
    private Date assignedDate;
    private EMPLOYEE assignee;
    private EMPLOYEE employeeByCrmd;
    private SKILL skillBySkillId;

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public EMPLOYEE getAssigneeId() {
        return assignee;
    }

    public void setAssigneeId(EMPLOYEE assigneeId) {
        this.assignee = assigneeId;
    }


    public EMPLOYEE getEmployeeByCrmd() {
        return employeeByCrmd;
    }

    public void setEmployeeByCrmd(EMPLOYEE employeeByCrmd) {
        this.employeeByCrmd = employeeByCrmd;
    }

    public SKILL getSkillBySkillId() {
        return skillBySkillId;
    }

    public void setSkillBySkillId(SKILL skillBySkillId) {
        this.skillBySkillId = skillBySkillId;
    }

    public SKILL_SET(Date assignedDate, EMPLOYEE assignee, EMPLOYEE employeeByCrmd, SKILL skillBySkillId) {
        this.assignedDate = assignedDate;
        this.assignee = assignee;
        this.employeeByCrmd = employeeByCrmd;
        this.skillBySkillId = skillBySkillId;
    }
}
