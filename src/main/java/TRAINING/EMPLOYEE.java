package TRAINING;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class EMPLOYEE {


    private String CRMD;
    private String AMBIENT;
    private String POSITION;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private Set<SKILL_SET> skill_set = new HashSet<SKILL_SET>(0);

    public String getCRMD() {
        return CRMD;
    }

    public void setCRMD(String CRMD) {
        this.CRMD = CRMD;
    }

    public String getAMBIENT() {
        return AMBIENT;
    }

    public void setAMBIENT(String AMBIENT) {
        this.AMBIENT = AMBIENT;
    }

    public String getPOSITION() {
        return POSITION;
    }

    public void setPOSITION(String POSITION) {
        this.POSITION = POSITION;
    }

    public Set<SKILL_SET> getSkill_set() {
        return skill_set;
    }

    public void setSkill_set(Set<SKILL_SET> skill_set) {
        this.skill_set = skill_set;
    }
}
