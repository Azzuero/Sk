package TRAINING;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "SKILL_SET", schema = "JUNITTEST", catalog = "")
public class SKILL_SET {

    private Time assignedDate;
    private String assigneeId;
    private EMPLOYEE employeeByCrmd;
    private SKILL skillBySkillId;

    public Time getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Time assignedDate) {
        this.assignedDate = assignedDate;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }
    @ManyToOne
    @JoinColumn(name = "CRMD", referencedColumnName = "CRMD")
    public EMPLOYEE getEmployeeByCrmd() {
        return employeeByCrmd;
    }

    public void setEmployeeByCrmd(EMPLOYEE employeeByCrmd) {
        this.employeeByCrmd = employeeByCrmd;
    }

    @ManyToOne
    @JoinColumn(name = "SKILL_ID", referencedColumnName = "ID")
    public SKILL getSkillBySkillId() {
        return skillBySkillId;
    }

    public void setSkillBySkillId(SKILL skillBySkillId) {
        this.skillBySkillId = skillBySkillId;
    }
}
