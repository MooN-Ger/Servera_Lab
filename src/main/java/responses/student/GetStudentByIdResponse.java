package responses.student;

import entities.Student;

public class GetStudentByIdResponse {
    private Student student;

    public GetStudentByIdResponse(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
