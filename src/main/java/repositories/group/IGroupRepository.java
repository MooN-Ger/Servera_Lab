package repositories.group;

import entities.Group;
import exceptions.RepositoryException;

import java.util.List;

public interface IGroupRepository {
    long addGroup(String name) throws RepositoryException;
    void editGroup(Group group) throws RepositoryException;
    Group getGroupById(long id) throws RepositoryException;
    List<Group> getAllGroups() throws RepositoryException;
    void deleteGroup(long id) throws RepositoryException;
}
