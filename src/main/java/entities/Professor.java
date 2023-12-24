package entities;

import java.util.Objects;

public class Professor {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;

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

    public Professor() {
        this.id = null;
        this.name = "name";
        this.surname = "surname";
        this.patronymic = "patronymic";
    }

    public Professor(Long id, String name, String surname, String patronymic){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id) && Objects.equals(name, professor.name) && Objects.equals(surname, professor.surname) && Objects.equals(patronymic, professor.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic);
    }
}
