package responses.group;

public class AddGroupResponse {
    private final long idGroup;

    public AddGroupResponse(long idGroup) {
        this.idGroup = idGroup;
    }

    public long getIdGroup() {
        return idGroup;
    }
}
