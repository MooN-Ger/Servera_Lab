package entities;

import models.Statuses;

import java.util.Objects;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Statuses status;
    private Long GroupId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Statuses getStatus() {
        return status;
    }

    public Long getGroupId() {
        return GroupId;
    }

    public Student() {
        this.id = null;
        this.name = "name";
        this.surname = "surname";
        this.patronymic = "patronymic";
        this.status = Statuses.UNKNOWN;
        this.GroupId = null;
    }

    public Student(Long id, String name, String surname, String patronymic, Statuses status, Long studentsGroupId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.status = status;
        this.GroupId = studentsGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(patronymic, student.patronymic) && status == student.status && Objects.equals(GroupId, student.GroupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, status, GroupId);
    }
}
