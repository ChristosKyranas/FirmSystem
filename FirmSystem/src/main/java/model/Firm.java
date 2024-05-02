package model;

public class Firm {

    private int firmId;
    private String name;
    private int active;

    public int getFirmId() {
        return firmId;
    }

    public void setFirmId(int firmId) {
        this.firmId = firmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Firm(int firmId, String name, int active) {
        this.firmId = firmId;
        this.name = name;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "firmId=" + firmId +
                ", name='" + name + '\'' +
                '}';
    }
}
