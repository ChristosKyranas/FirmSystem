package domain;

public class Job extends Employee{
    //variables checked "OK"
    private int jobId;
    private String jobTitle;
    private int salary;
    private int vacancies;
    private String hiringDate;
    private int employee;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getVacancies() {
        return vacancies;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", vacancies=" + vacancies +
                ", jobTitle='" + jobTitle + '\'' +
                ", hiringDate='" + hiringDate + '\'' +
                '}';
    }
}
