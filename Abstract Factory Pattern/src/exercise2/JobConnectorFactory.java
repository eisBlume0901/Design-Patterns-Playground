package exercise2;

public abstract class JobConnectorFactory
{
      protected abstract Job createJob(String jobType);
      public Job offerJob(String jobType)
      {
          Job job = null;

          job = createJob(jobType);

          return job;
      }
}
interface JobHiringPost
{
    public JobHiringPosition createJobPosition();
    public JobRequirements createRequirements();
}

class JobHiringPosition
{
    public enum JobLevel {
        ENTRY, MID, SENIOR
    }

    private JobLevel level;

    public enum JobType
    {
        ACCOUNTANT, SOFTWARE_DEVELOPER, HUMAN_RESOURCES_MANAGER;
    }

    private JobType type;

    public enum JobEmploymentType
    {
        FULL_TIME, PART_TIME;
    }

    private JobEmploymentType employmentType;

    public JobLevel getLevel() {
        return level;
    }

    public void setLevel(JobLevel level) {
        this.level = level;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public JobEmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(JobEmploymentType employmentType) {
        this.employmentType = employmentType;
    }
}

class JobRequirements
{
    public enum EducationalDegree
    {
        BACHELOR, MASTER, DOCTORAL
    }

    private EducationalDegree educationalDegree;

    public String responsibilities;

    public EducationalDegree getEducationalDegree() {
        return educationalDegree;
    }

    public void setEducationalDegree(EducationalDegree educationalDegree) {
        this.educationalDegree = educationalDegree;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }
}

class Job
{

}

class Accountant extends Job
{

}

class SoftwareDeveloper extends Job
{

}


