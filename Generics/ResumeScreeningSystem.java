import java.util.ArrayList;
import java.util.List;


abstract class JobRole {
    String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public abstract void evaluateResume();
    public String getCandidateName() {
        return candidateName;
    }
}


class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println(candidateName + ": Screening for Software Engineer - Focus on coding skills and system design.");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println(candidateName + ": Screening for Data Scientist - Focus on ML models and data handling.");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluateResume() {
        System.out.println(candidateName + ": Screening for Product Manager - Focus on business strategy and leadership.");
    }
}


class Resume<T extends JobRole> {
    private List<T> resumeList = new ArrayList<>();
    public void addResume(T resume) {
        resumeList.add(resume);
    }
    public List<T> getAllResumes() {
        return resumeList;
    }
    public static void processScreening(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.evaluateResume();
        }
    }
}


public class ResumeScreeningSystem {
    public static void main(String[] args) {

        Resume<JobRole> resume = new Resume<>();
        resume.addResume(new SoftwareEngineer("John"));
        resume.addResume(new DataScientist("Jane"));
        resume.addResume(new ProductManager("Bob"));
        resume.addResume(new SoftwareEngineer("Alice"));
        resume.addResume(new DataScientist("Mike"));
        resume.addResume(new ProductManager("Emma"));
        resume.processScreening(resume.getAllResumes());
    }
}