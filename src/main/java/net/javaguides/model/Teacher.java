package net.javaguides.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection= "teachers")
public class Teacher {

    @Id
    private String id;
    private String teacherName;
    private String teacherSalary;
    private String teacherGender;
    private String teacherSubject;
    private String teacherClass;

    public Teacher() {}

    // getters and setters

    public String getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(String teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
    }
}
