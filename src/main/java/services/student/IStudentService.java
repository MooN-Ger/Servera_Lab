package services.student;

import entities.Student;
import exceptions.ServiceException;
import models.Statuses;

import java.util.List;

public interface IStudentService {
    long addStudent(String name, String surname, String patronymic, Statuses status, long groupId) throws ServiceException;
    void editStudent(Student student) throws ServiceException;
    Student getStudentById(long id) throws ServiceException;
    List<Student> getAllStudentsByGroupId(long groupId) throws ServiceException;
    void deleteStudent(long id) throws ServiceException;
}
