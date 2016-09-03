package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    // Regular expression for the Student ID pattern
    private static final String course_idREGEX = "^[0-9]{6}$";

    // all private attributes
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;

    public Course() {
        this.course_name = "TBA";
        this.course_id = "000000";
        this.lecturer = "TBA";
        this.max_students = 30;
        this.no_students = 0;
    }

    public Course(String n, String cid) {
        this.course_name = n;
        this.course_id = cid;
        this.lecturer = "TBA";
        this.max_students = 30;
        this.no_students = 0;
    }

    public Course(String n, String cid, String l) {
        this.course_name = n;
        this.course_id = cid;
        this.lecturer = l;
        this.max_students = 30;
        this.no_students = 0;
    }

    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = cid;
        this.lecturer = l;
        this.max_students = max;
        this.no_students = 0;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        if(course_name.equalsIgnoreCase("")) return;

        this.course_name = course_name;

    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {

        if(course_id.equalsIgnoreCase("")) return;

        if(!this.isValidCourse_id(course_id)) return;

        this.course_id = course_id;

    }

    // implement the other get and set methods here
    public String getLecturer() {
        return this.lecturer;
    }

    public void setLecturer(String lecturer) {
        if(lecturer.equalsIgnoreCase("")) return;
        this.lecturer = lecturer;
    }

    public int getMax_students() {
        return this.max_students;
    }

    public void setMax_students(int max_students) {
        if(max_students < 10 ) return;
        this.max_students = max_students;
    }

    public int getNo_students() {
        return this.no_students;
    }

    public void setNo_students(int no_students) {
        if(no_students > this.max_students) return;
        if(no_students < 0 ) return;

        this.no_students = no_students;
    }

    @Override
    public String toString() {
        String o = this.course_name + " ("
                + this.course_id + "), Teacher: "
                + this.lecturer + ", has ";

        if(this.no_students < 1 ) {
            o = o + "NO student, [maximum: "+max_students+"]";
        }else if(this.no_students == 1){
            o = o + "ONE student, [maximum: "+max_students+"]";
        }else{
            o = o + this.no_students + " students, [maximum: "+max_students+"]";
        }

        return o;
    }

    private boolean isValidCourse_id(String id) {

        Pattern r = Pattern.compile(this.course_idREGEX);

        Matcher m = r.matcher(id);

        if (!m.find())  return false;

        return true;
    }

}
