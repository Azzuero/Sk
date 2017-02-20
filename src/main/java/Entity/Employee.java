package Entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
public class Employee {
    private String crmd;
    private String ambient;
    private String position;

    @Id
    @OneToMany(mappedBy = "employeeByCrmd", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    public String getCrmd() {
        return crmd;
    }

    public void setCrmd(String crmd) {
        this.crmd = crmd;
    }

    @Basic
    @Column(name = "AMBIENT", nullable = true, length = 20)
    public String getAmbient() {
        return ambient;
    }

    public void setAmbient(String ambient) {
        this.ambient = ambient;
    }

    @Basic
    @Column(name = "POSITION", nullable = true, length = 20)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee() {
    }

    public Employee(String crmd, String ambient, String position) {
        this.crmd = crmd;
        this.ambient = ambient;
        this.position = position;
    }
}