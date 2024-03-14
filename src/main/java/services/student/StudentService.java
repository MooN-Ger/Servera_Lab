package services.student;

import entities.Student;
import exceptions.ServiceException;
import models.Statuses;
import repositories.student.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public long addStudent(String name, String surname, String patronymic, Statuses status, long groupId) throws ServiceException {
        try {
            return repository.addStudent(name, surname, patronymic, status, groupId);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void editStudent(Student student) throws ServiceException {
        try {
            repository.editStudent(student);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Student getStudentById(long id) throws ServiceException {
        try {
            return repository.getStudentById(id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Student> getAllStudentsByGroupId(long id) throws ServiceException {
        try {
            return repository.getAllStudentsByGroupId(id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteStudent(long id) throws ServiceException {
        try {
            repository.deleteStudent(id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
