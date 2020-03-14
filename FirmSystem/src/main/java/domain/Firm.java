package domain;

public class Firm {

    private int firmId;
    private String name;

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

    @Override
    public String toString() {
        return "Firm{" +
                "firmId=" + firmId +
                ", name='" + name + '\'' +
                '}';
    }
}
