package requests.student;

import entities.Student;
import models.Statuses;

public class EditStudentRequest {
    private Student student;

    public EditStudentRequest(long id, String name, String surname, String patronymic, Statuses status, long groupId) {
        this.student = new Student(id, name, surname, patronymic, status, groupId);
    }

    public Student getStudent() {
        return student;
    }
}
