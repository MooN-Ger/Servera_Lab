package services.group;

import entities.Group;
import exeptions.ServiceException;
import repositories.group.GroupRepository;

import java.util.List;

public class GroupService implements IGroupService {
    private GroupRepository repository;
    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public long addGroup(String name) throws ServiceException {
        try {
            return repository.addGroup(name);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void editGroup(Group group) throws ServiceException {
        try {
            repository.editGroup(group);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Group getGroupById(long id) throws ServiceException {
        try {
            return repository.getGroupById(id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Group> getAllGroups() throws ServiceException {
        try {
            return repository.getAllGroups();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteGroup(long id) throws ServiceException {
        try {
            repository.deleteGroup(id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
