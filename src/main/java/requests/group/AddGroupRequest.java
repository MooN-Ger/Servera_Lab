package requests.group;

public class AddGroupRequest {
    private String name;

    public AddGroupRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
