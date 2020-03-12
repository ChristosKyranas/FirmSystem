package models;

public class Education {

    private String bachelor;
    private String master;
    private String phD;
    private int certificate;

    public String getBachelor() {
        return bachelor;
    }

    public void setBachelor(String bachelor) {
        this.bachelor = bachelor;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getPhD() {
        return phD;
    }

    public void setPhD(String phD) {
        this.phD = phD;
    }

    public int getCertificate() {
        return certificate;
    }

    public void setCertificate(int certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Education{" +
                "bachelor='" + bachelor + '\'' +
                ", master='" + master + '\'' +
                ", phD='" + phD + '\'' +
                ", certificate=" + certificate +
                '}';
    }
}
