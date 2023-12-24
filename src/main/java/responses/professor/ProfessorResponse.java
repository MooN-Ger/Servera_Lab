package responses.professor;

public class ProfessorResponse {
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

    public ProfessorResponse() {
        this.id = null;
        this.name = "name";
        this.surname = "surname";
        this.patronymic = "patronymic";
    }

    public ProfessorResponse(Long id, String name, String surname, String patronymic){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }
}
