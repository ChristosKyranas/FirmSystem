package domain;

public class Employee {

    private int employeeId;
    private int personalInfo;
    private int job;
    private int education;
    private int branch;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(int personalInfo) {
        this.personalInfo = personalInfo;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", personalInfo=" + personalInfo +
                ", job=" + job +
                ", education=" + education +
                ", branch=" + branch +
                '}';
    }
}
