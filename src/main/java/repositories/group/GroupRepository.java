package repositories.group;

import entities.Group;
import exeptions.RepositoryException;
import repositories.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupRepository implements IGroupRepository {
    private DataBase db;
    private long counter;

    public GroupRepository(DataBase db) {
        this.db = db;
        counter = 0;
    }

    @Override
    public long addGroup(String name) throws RepositoryException {
        Map<Long, Group> groupMap = db.getGroupsTable();
        long key;

        if (groupMap.keySet().isEmpty()) {
            key = 0;
        }
        else {
            key = ++counter;
        }
        groupMap.put(key, new Group(key, name));
        return key;
    }

    @Override
    public void editGroup(Group group) throws RepositoryException {
        if (!db.getGroupsTable().containsKey(group.getId())) throw new RepositoryException("Not contains expected group");
        db.getGroupsTable().replace(group.getId(), group);
    }

    @Override
    public Group getGroupById(long id) throws RepositoryException {
        if (!db.getGroupsTable().containsKey(id)) throw new RepositoryException("Not contains expected key");
        return db.getGroupsTable().get(id);
    }

    @Override
    public List<Group> getAllGroups() throws RepositoryException {
        return new ArrayList<>(db.getGroupsTable().values());
    }

    @Override
    public void deleteGroup(long id) throws RepositoryException {
        if (!db.getGroupsTable().containsKey(id)) throw new RepositoryException("Not contains expected key");
        db.getGroupsTable().remove(id);
    }
}
