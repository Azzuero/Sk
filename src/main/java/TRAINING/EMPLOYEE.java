package TRAINING;

import javax.persistence.*;
@Entity
public class EMPLOYEE {
    private String crmd;
    private String ambient;
    private String position;

    @Id
    @Column(name = "CRMD")
    public String getCrmd() {
        return crmd;
    }

    public void setCrmd(String crmd) {
        this.crmd = crmd;
    }

    @Column(name = "AMBIENT")
    public String getAmbient() {
        return ambient;
    }

    public void setAmbient(String ambient) {
        this.ambient = ambient;
    }

    @Column(name = "POSITION")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}