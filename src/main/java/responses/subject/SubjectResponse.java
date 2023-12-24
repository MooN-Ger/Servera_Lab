package responses.subject;

public class SubjectResponse {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SubjectResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
