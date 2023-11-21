package exercise2;

public abstract class CourseProgramFactory
{
    protected abstract Course createCourse(String courseTitle);

    public Course offerCourse(String courseTitle)
    {
        Course course = null;

        course = createCourse(courseTitle);

        return course;
    }
}

class JavaProgrammingFactory extends CourseProgramFactory
{
    @Override
    protected Course createCourse(String courseTitle) {

        if (courseTitle.equalsIgnoreCase("Java Basics"))
            return new JavaBasics();
        if (courseTitle.equalsIgnoreCase("Object-Oriented Programming"))
            return new OOPWithJava();
        else if (courseTitle.equalsIgnoreCase("Exception Handling"))
            return new ExceptionHandlingWithJava();
        else return null;
    }
}

class WebDevelopmentFactory extends CourseProgramFactory
{
    @Override
    protected Course createCourse(String courseTitle) {

        if (courseTitle.equalsIgnoreCase("Web Development"))
            return new IntroductionToWebDev();
        else if (courseTitle.equalsIgnoreCase("HTML and CSS"))
            return new HTMLandCSS();
        else return null;
    }
}

class DataScienceFactory extends CourseProgramFactory
{
    @Override
    protected Course createCourse(String courseTitle) {

        if (courseTitle.equalsIgnoreCase("Machine Learning"))
            return new MachineLearning();
        else if (courseTitle.equalsIgnoreCase("Statistics"))
            return new StatisticalAnalysis();
        else return null;
    }
}
abstract class Course
{
    private String courseTitle;
    private String courseInstructor;
    private int courseDuration;

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }
}

class JavaBasics extends Course
{
    public JavaBasics()
    {
        setCourseTitle("Java Basics");
        setCourseDuration(3);
        setCourseInstructor("Briar Randolph");
    }
}

class OOPWithJava extends Course
{
    public OOPWithJava()
    {
        setCourseTitle("Object-Oriented Programming with Java");
        setCourseDuration(9);
        setCourseInstructor("Wilfrid Porter");
    }
}

class ExceptionHandlingWithJava extends Course
{
    public ExceptionHandlingWithJava()
    {
        setCourseTitle("Exception Handling with Java");
        setCourseDuration(5);
        setCourseInstructor("Jared Gunner");
    }
}

class IntroductionToWebDev extends Course
{
    public IntroductionToWebDev()
    {
        setCourseTitle("Introduction to Web Development");
        setCourseDuration(3);
        setCourseInstructor("Kolby Radcliff");
    }
}

class HTMLandCSS extends Course
{
    public HTMLandCSS()
    {
        setCourseTitle("Building Structure with HTML and Styling with CSS");
        setCourseDuration(5);
        setCourseInstructor("Dillon Thorburn");
    }
}

class MachineLearning extends Course
{
    public MachineLearning()
    {
        setCourseTitle("Machine Learning Fundamentals");
        setCourseDuration(4);
        setCourseInstructor("Grover Nicholas");
    }
}

class StatisticalAnalysis extends Course
{
    public StatisticalAnalysis()
    {
        setCourseTitle("Descriptive Statistics and Inferential Statistics");
        setCourseDuration(10);
        setCourseInstructor("Malcom Ripley");
    }
}

class Main
{
    public static void main(String[] args)
    {
        CourseProgramFactory javaDevelopmentFactory = new JavaProgrammingFactory();
        Course javaBasics = javaDevelopmentFactory.offerCourse("Java Basics");

        System.out.println("Title : " + javaBasics.getCourseTitle());
        System.out.println("Duration: " + javaBasics.getCourseDuration());
        System.out.println("Instructor: " + javaBasics.getCourseInstructor());

        System.out.println();

        CourseProgramFactory dataScienceFactory = new DataScienceFactory();
        Course statistics = dataScienceFactory.offerCourse("Statistics");

        System.out.println("Title: " + statistics.getCourseTitle());
        System.out.println("Duration: " +  statistics.getCourseDuration());
        System.out.println("Instructor: " + statistics.getCourseInstructor());
    }
}