package repositories;

import entities.Group;
import entities.Professor;
import entities.Student;

import java.util.Map;

public class DataBase {
    private final Map<Long, Student> studentsTable;
    private final Map<Long, Group> groupsTable;
    private final Map<Long, Professor> professorsTable;

    public DataBase(Map<Long, Student> studentsTable, Map<Long, Group> groupsTable, Map<Long, Professor> professorsTable) {
        this.studentsTable = studentsTable;
        this.groupsTable = groupsTable;
        this.professorsTable = professorsTable;
    }

    public Map<Long, Student> getStudentsTable() {
        return studentsTable;
    }

    public Map<Long, Group> getGroupsTable() {
        return groupsTable;
    }

    public Map<Long, Professor> getProfessorsTable() {
        return professorsTable;
    }
}
