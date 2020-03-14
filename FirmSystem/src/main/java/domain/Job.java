package domain;

public class Job {

    private int jobId;
    private int vacancies;
    private String jobTitle;
    private String hiringDate;

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
