package repositories;

import entities.Group;
import entities.Student;

import java.util.Map;

public class DataBase {
    private Map<Long, Student> studentsTable;
    private Map<Long, Group> groupsTable;

    public DataBase(Map<Long, Student> studentsTable, Map<Long, Group> groupsTable) {
        this.studentsTable = studentsTable;
        this.groupsTable = groupsTable;
    }

    public Map<Long, Student> getStudentsTable() {
        return studentsTable;
    }

    public Map<Long, Group> getGroupsTable() {
        return groupsTable;
    }
}
