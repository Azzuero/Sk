package TRAINING;

import java.util.Date;

public class SKILL_SET {
   private String CRMD;
    private int SKILL_ID;
    private Date ASSIGNET_DATE;
    private String ASSIGNEE_ID;

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
