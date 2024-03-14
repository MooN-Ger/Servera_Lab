package responses.student;

import entities.Student;

public class GetStudentByIdResponse {
    private final Student student;

    public GetStudentByIdResponse(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
