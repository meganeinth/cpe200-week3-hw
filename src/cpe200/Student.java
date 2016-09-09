package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    // declare your attributes here

    private String student_name;
    private String student_id;
    private int year_of_birth;
    private boolean status;

    private String _default_name = "John Doe";
    private String _default_id = "560610000";
    private int _default_yob = 1990;
    private boolean _default_status = false;

    private static final String student_id_regex="^5([6-9]?)061([0-2]?)([0-9]{3})$";

    public Student(){ this("","",0,false); }

    public Student(String name,String id) { this(name,id,0,false); }

    public Student(String name,String id,int year) { this(name,id,year,false); }

    public Student(String name,String id,int year,boolean status) {
        if(!name.equalsIgnoreCase("")){
            this.student_name = name;
        }else{
            this.student_name = this._default_name;
        }

        if(this.isValidStudent_id(id)){
            this.student_id = id;
        }else{
            this.student_id = this._default_id;
        }
        if(this.isValidYOB(year)) {
            this.year_of_birth = year;
        }else{
            this.year_of_birth = this._default_yob;
        }
        this.status = status;
    }

    public void setName(String name){
        if(name.equalsIgnoreCase("")) return;

        this.student_name = name;
    }

    public void setStudent_id(String id){
        if(id.equalsIgnoreCase("")) return;

        if(!this.isValidStudent_id(id)) return;

        this.student_id = id;
    }

    public void setYearOfBirth(int year){
        if(!this.isValidYOB(year)) return;

        this.year_of_birth = year;
    }

    public String getName(){
        return this.student_name;
    }

    public String getStudent_id(){
        return this.student_id;
    }

    public int getYearOfBirth(){

        return this.year_of_birth;

    }

    public boolean getStatus(){

        return this.status;

    }

    public boolean isActive(){
        return (this.status == true);
    }

    @Override
    public String toString() {
        String o = this.student_name + " ("
                + this.student_id + ") was born in "
                + this.year_of_birth + " is an ";

        if(this.isActive()==false){
            o = o + "INACTIVE ";
        }else{
            o = o + "ACTIVE ";
        }

        o = o + "student.";
        return o;
    }

    private boolean isValidStudent_id(String id) {

        Pattern r = Pattern.compile(this.student_id_regex);

        Matcher m = r.matcher(id);

        if (!m.find())  return false;

        return true;
    }

    private boolean isValidYOB(int yob) {

        if(yob < 1990)  return false;

        return true;
    }

}
