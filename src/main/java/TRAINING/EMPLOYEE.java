package TRAINING;

public class EMPLOYEE {
    private String crmd;
    private String ambient;
    private String position;

    public String getCrmd() {
        return crmd;
    }

    public void setCrmd(String crmd) {
        this.crmd = crmd;
    }

    public String getAmbient() {
        return ambient;
    }

    public void setAmbient(String ambient) {
        this.ambient = ambient;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public EMPLOYEE(String crmd, String ambient, String position) {
        this.crmd = crmd;
        this.ambient = ambient;
        this.position = position;
    }
}