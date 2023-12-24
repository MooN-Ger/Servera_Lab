package responses.student;

import entities.Group;
import models.Statuses;

public class StudentResponse {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private Statuses status;
    private Group group;

    public long getId() {
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

    public Statuses getStatus(){
        return status;
    }

    public Group getGroup() {
        return group;
    }

    public StudentResponse(long id, String name, String surname, String patronymic, Statuses status, Group group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.status = status;
        this.group = group;
    }
}
