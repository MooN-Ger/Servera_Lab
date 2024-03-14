package entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import models.Statuses;

import java.util.Objects;

public class Student {
    private final Long id;
    private final String name;
    private final String surname;
    private final String patronymic;
    private final Statuses status;
    private final long GroupId;

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

    public long getGroupId() {
        return GroupId;
    }

    @JsonCreator
    public Student(@JsonProperty(value = "id")Long id,
                   @JsonProperty(value = "name")String name,
                   @JsonProperty(value = "surname")String surname,
                   @JsonProperty(value = "patronymic")String patronymic,
                   @JsonProperty(value = "status")Statuses status,
                   @JsonProperty(value = "group")long studentsGroupId) {
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
