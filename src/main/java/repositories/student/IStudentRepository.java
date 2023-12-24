package repositories.student;

import entities.Student;
import exeptions.RepositoryException;
import models.Statuses;

import java.util.List;

public interface IStudentRepository {
    long addStudent(String name, String surname, String patronymic, Statuses status, long groupId) throws RepositoryException;
    void editStudent(Student student) throws RepositoryException;
    Student getStudentById(long id) throws RepositoryException;
    List<Student> getAllStudentsByGroupId(long groupId) throws RepositoryException;
    void deleteStudent(long id) throws RepositoryException;
}
