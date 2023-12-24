package services.group;

import entities.Group;
import exeptions.ServiceException;

import java.util.List;

public interface IGroupService {
    long addGroup(String name) throws ServiceException;
    void editGroup(Group group) throws ServiceException;
    Group getGroupById(long id) throws ServiceException;
    List<Group> getAllGroups() throws ServiceException;
    void deleteGroup(long id) throws ServiceException;
}
