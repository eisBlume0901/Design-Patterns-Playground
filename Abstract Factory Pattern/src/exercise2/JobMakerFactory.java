package exercise2;

enum JobType
{
    ACCOUNTANT,
    DATA_SCIENTIST,
    HUMAN_RESOURCES_MANAGER,
    SOFTWARE_ARCHITECT,
}

enum EducationalDegree
{
    BACHELOR,
    MASTER,
    DOCTORAL
}

enum JobLevel
{
    ENTRY,
    MID,
    SENIOR
}

enum EmploymentType
{
    FULL_TIME,
    PART_TIME,
    PROJECT_BASED
}

class JobResponsibilities
{

}
interface JobMakerFactory
{
    public JobType createJobType();

}

class QuantumInnovationsCompany implements JobMakerFactory
{
    @Override
    public JobType createJobType() {
        return null;
    }
}
class Job
{

}

abstract class JobConnectorFactory
{
    protected abstract Job createJob(JobType jobType);

    public Job offerJob(JobType jobType)
    {
        Job job = null;

        job = createJob(jobType);

        return job;
    }
}
