package responses.professor;

import entities.Professor;

public class GetProfessorsByPositionResponse {

    private final Professor professor;

    public GetProfessorsByPositionResponse(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }
}
