package requests.professor;

import entities.Professor;

public class EditProfessorRequest {

    private final Professor professor;

    public EditProfessorRequest(long id, String name, String surname, String patronymic, String position) {
        this.professor = new Professor(id, name, surname, patronymic, position);
    }

    public Professor getProfessor() {
        return professor;
    }
}
