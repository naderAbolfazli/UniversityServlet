package ir.maktab.model;

/**
 * Created by nader on 11/18/2017.
 */
public class Student {
    private Integer id;
    private String name;
    private String dept;
    private int supervisor_id;

    public Student(String name, String dept, int sid){
        this.name=name;
        this.dept=dept;
        this.supervisor_id =sid;
    }
    public Student(Integer id, String name, String dept, int sid){
        this.id =id;
        this.name=name;
        this.dept=dept;
        this.supervisor_id =sid;
    }

    public Student(){}

    public Student(int id) {
        this.id =id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) { this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(int supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", supervisor_id=" + supervisor_id +
                '}';
    }


}
