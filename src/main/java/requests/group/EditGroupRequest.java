package requests.group;

public class EditGroupRequest {
    private long id;
    private String name;

    public EditGroupRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
