package responses.group;

public class GroupResponse {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GroupResponse(long id, String name){
        this.id = id;
        this.name = name;
    }
}
