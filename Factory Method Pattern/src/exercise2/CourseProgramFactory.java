package exercise2;

public abstract class CourseProgramFactory
{
    public abstract Course offerCourse(String courseTitle);

    public Course createCourse(String courseTitle)
    {
        Course course = null;

        course = offerCourse(courseTitle);

        return course;
    }
}

class JavaProgrammingFactory extends CourseProgramFactory
{
    @Override
    public Course offerCourse(String courseTitle) {

        if (courseTitle.equalsIgnoreCase("Java Basics"))
            return new JavaBasics();
        if (courseTitle.equalsIgnoreCase("Object-Oriented Programming"))
            return new OOPWithJava();
        if (courseTitle.equalsIgnoreCase("Exception Handling"))
            return new ExceptionHandlingWithJava();
        else return null;
    }
}

class WebDevelopmentFactory extends CourseProgramFactory
{
    @Override
    public Course offerCourse(String courseTitle) {

        if (courseTitle.equalsIgnoreCase("Web Development"))
            return new IntroductionToWebDev();
        if (courseTitle.equalsIgnoreCase("HTML and CSS"))
            return new HTMLandCSS();
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

