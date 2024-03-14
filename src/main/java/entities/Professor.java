package entities;

import java.util.Objects;

public class Professor {
    private final Long id;
    private final String name;
    private final String surname;
    private final String patronymic;
    private final String position;

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

    public String getPosition() {
        return position;
    }

    public Professor() {
        this.id = null;
        this.name = "name";
        this.surname = "surname";
        this.patronymic = "patronymic";
        this.position = "position";
    }

    public Professor(Long id, String name, String surname, String patronymic, String position){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id) && Objects.equals(name, professor.name) && Objects.equals(surname, professor.surname) && Objects.equals(patronymic, professor.patronymic) && Objects.equals(position, professor.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, position);
    }
}
