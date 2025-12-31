package net.javaguides.model;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;
    private Integer age;
    private String notes;
    private Double salary;

    public User() {}

    public User(String name, Integer age, String notes, Double salary) {
        this.name = name;
        this.age = age;
        this.notes = notes;
        this.salary = salary;
    }

    // getters & setters
    public String getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
