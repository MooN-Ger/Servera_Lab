package responses.group;

import entities.Group;

public class GetGroupByIdResponse {
    private final Group group;

    public GetGroupByIdResponse(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }
}
