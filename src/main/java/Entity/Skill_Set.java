package Entity;

import java.util.Date;


public class Skill_Set {
    private Date assignedDate;
    private Employee assignee;
    private Employee employeeByCrmd;
    private Skill skillBySkillId;

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Employee getAssigneeId() {
        return assignee;
    }

    public void setAssigneeId(Employee assigneeId) {
        this.assignee = assigneeId;
    }


    public Employee getEmployeeByCrmd() {
        return employeeByCrmd;
    }

    public void setEmployeeByCrmd(Employee employeeByCrmd) {
        this.employeeByCrmd = employeeByCrmd;
    }

    public Skill getSkillBySkillId() {
        return skillBySkillId;
    }

    public void setSkillBySkillId(Skill skillBySkillId) {
        this.skillBySkillId = skillBySkillId;
    }

    public Skill_Set(Date assignedDate, Employee assignee, Employee employeeByCrmd, Skill skillBySkillId) {
        this.assignedDate = assignedDate;
        this.assignee = assignee;
        this.employeeByCrmd = employeeByCrmd;
        this.skillBySkillId = skillBySkillId;
    }
}
