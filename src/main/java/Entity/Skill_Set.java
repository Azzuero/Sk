package Entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Skill_Set {
    private Date assignedDate;
    private Employee assignee;
    @Id
    private Employee employeeByCrmd;
    @Id
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


    public Skill_Set(Date assignedDate, Employee assignee, Employee employeeByCrmd, Skill skillBySkillId) {
        this.assignedDate = assignedDate;
        this.assignee = assignee;
        this.employeeByCrmd = employeeByCrmd;
        this.skillBySkillId = skillBySkillId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "CRMD", nullable = false)
    public Employee getEmployeeByCrmd() {
        return employeeByCrmd;
    }

    public void setEmployeeByCrmd(Employee employeeByCrmd) {
        this.employeeByCrmd = employeeByCrmd;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "SKILL_ID", nullable = false)
    public Skill getSkillBySkillId() {
        return skillBySkillId;
    }

    public void setSkillBySkillId(Skill skillBySkillId) {
        this.skillBySkillId = skillBySkillId;
    }

    public Skill_Set() {
    }
    
}
