package create;

/**
 * @author Wuyihu
 * @version 1.0
 * @date 2022/3/17
 */
public class Builder {
    public static void main(String[] args) {
        Course build = new CourseBuilder().addName("设计模式")
                .addMeans("教程资料")
                .addNote("课堂笔记")
                .addHomework("课后作业")
                .build();
    }
}
class Course {
    private String name;    // 课程名称
    private String means;    // 教程资料
    private String note;   // 学习笔记
    private String homework;    // 课后作业

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    @Override
    public String toString() {
        return "CourseBuilder{" + "name='" + name + '\'' + ",means='" + means + '\'' + ",note='" + note + '\'' + ",homework='" + homework + '\'' + '}';
    }
}
class CourseBuilder {
    private Course course = new Course();
    public CourseBuilder addName(String name){
        course.setName(name);
        return this;
    }
    public CourseBuilder addMeans(String means){
        course.setMeans(means);
        return this;
    }
    public CourseBuilder addNote(String note){
        course.setNote(note);
        return this;
    }
    public CourseBuilder addHomework(String homework){
        course.setHomework(homework);
        return this;
    }
    public Course build(){
        return course;
    }
}