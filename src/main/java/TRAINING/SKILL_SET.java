package TRAINING;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SKILL_SET {

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "EMPLOYEE", nullable = false)
    private EMPLOYEE CRMD;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "SKILL_ID", nullable = false)
    private SKILL SKILL_ID;

    private Date ASSIGNET_DATE;

    private String ASSIGNEE_ID;

    public EMPLOYEE getCRMD() {
        return CRMD;
    }

    public void setCRMD(EMPLOYEE CRMD) {
        this.CRMD = CRMD;
    }

    public SKILL getSKILL_ID() {
        return SKILL_ID;
    }

    public void setSKILL_ID(SKILL SKILL_ID) {
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
