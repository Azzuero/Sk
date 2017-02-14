package TRAINING;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "SKILL_SET")
public class SKILL_SET implements Serializable {
    private Time assignedDate;
    private String assigneeId;
    private EMPLOYEE employeeByCrmd;
    private SKILL skillBySkillId;

    @Basic
    @Column(name = "ASSIGNED_DATE", nullable = true)
    public Time getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Time assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Column(name = "ASSIGNEE_ID", nullable = false, length = 10)
    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }


    @Id
    @ManyToOne
    @JoinColumn(name = "CRMD", referencedColumnName = "CRMD")
    public EMPLOYEE getEmployeeByCrmd() {
        return employeeByCrmd;
    }

    public void setEmployeeByCrmd(EMPLOYEE employeeByCrmd) {
        this.employeeByCrmd = employeeByCrmd;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "SKILL_ID", referencedColumnName = "ID")
    public SKILL getSkillBySkillId() {
        return skillBySkillId;
    }

    public void setSkillBySkillId(SKILL skillBySkillId) {
        this.skillBySkillId = skillBySkillId;
    }
}
