package TRAINING;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SKILL_SET {

    @Id
    private String CRMD;

    private int SKILL_ID;

    private Date ASSIGNET_DATE;

    private String ASSIGNEE_ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "SKILL", nullable = false)
    private SKILL skill;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "EMPLOYEE", nullable = false)
    private EMPLOYEE employee;

    public String getCRMD() {
        return CRMD;
    }

    public void setCRMD(String CRMD) {
        this.CRMD = CRMD;
    }

    public int getSKILL_ID() {
        return SKILL_ID;
    }

    public void setSKILL_ID(int SKILL_ID) {
        this.SKILL_ID = SKILL_ID;
    }

    public Date getASSIGNET_DATE() {
        return ASSIGNET_DATE;
    }

    public void setASSIGNET_DATE(Date ASSIGNET_DATE) {
        this.ASSIGNET_DATE = ASSIGNET_DATE;
    }

    public String getASSIGNEE_ID() {
        return ASSIGNEE_ID;
    }

    public void setASSIGNEE_ID(String ASSIGNEE_ID) {
        this.ASSIGNEE_ID = ASSIGNEE_ID;
    }
}
