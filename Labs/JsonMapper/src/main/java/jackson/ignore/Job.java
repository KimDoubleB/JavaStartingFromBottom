package jackson.ignore;

public class Job {
    String name;
    int averageSalary;
    String company;

    public Job() {
    }

    public Job(String name, int averageSalary, String company) {
        this.name = name;
        this.averageSalary = averageSalary;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getAverageSalary() {
        return averageSalary;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", averageSalary=" + averageSalary +
                ", company='" + company + '\'' +
                '}';
    }
}
