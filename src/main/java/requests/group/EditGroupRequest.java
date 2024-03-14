package requests.group;

import entities.Group;

public class EditGroupRequest {

    private final Group group;

    public EditGroupRequest(long id, String name) {
        this.group = new Group(id, name);
    }

    public Group getGroup() {
        return group;
    }
}
