package TRAINING;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SKILL", schema = "JUNITTEST", catalog = "")
public class SKILL {

    @Id
    private int ID;

    private String NAME;

    private int PARENT_ID;

    @OneToMany(mappedBy = "SKILL_ID", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private Set<SKILL_SET> skill_set = new HashSet<SKILL_SET>(0);

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getPARENT_ID() {
        return PARENT_ID;
    }

    public void setPARENT_ID(int PARENT_ID) {
        this.PARENT_ID = PARENT_ID;
    }

    public Set<SKILL_SET> getSkill_set() {
        return skill_set;
    }

    public void setSkill_set(Set<SKILL_SET> skill_set) {
        this.skill_set = skill_set;
    }
}
