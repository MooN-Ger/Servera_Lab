package repositories.student;

import entities.Student;
import exceptions.RepositoryException;
import models.Statuses;
import repositories.DataBase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRepository implements IStudentRepository {
    private final DataBase db;
    private long counter;

    public StudentRepository(DataBase db) {
        this.db = db;
        counter = 0;
    }

    @Override
    public long addStudent(String name, String surname, String patronymic, Statuses status, long groupId) throws RepositoryException {
        Map<Long, Student> studentMap = db.getStudentsTable();
        long key;
        if (studentMap.keySet().isEmpty()) {
            key = 0;
        }
        else {
            key = ++counter;
        }
        studentMap.put(key, new Student(key, name, surname, patronymic, status, groupId));
        return key;
    }

    @Override
    public void editStudent(Student student) throws RepositoryException {
        if (db.getStudentsTable().containsKey(student.getId())) throw new RepositoryException("Not contains expected student");
        db.getStudentsTable().replace(student.getId(), student);
    }

    @Override
    public Student getStudentById(long id) throws RepositoryException {
        if (db.getStudentsTable().containsKey(id)) throw new RepositoryException("Not contains expected key");
        return db.getStudentsTable().get(id);
    }

    @Override
    public List<Student> getAllStudentsByGroupId(long groupId) throws RepositoryException {
        return db.getStudentsTable().values().stream().filter(v -> v.getGroupId() == groupId)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(long id) throws RepositoryException {
        if (!db.getStudentsTable().containsKey(id)) throw new RepositoryException("Not contains expected key");
        db.getStudentsTable().remove(id);
    }
}
