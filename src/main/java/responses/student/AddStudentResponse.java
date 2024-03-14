package responses.student;

public class AddStudentResponse {
    private final long idStudent;

    public AddStudentResponse(long idStudent) {
        this.idStudent = idStudent;
    }

    public long getIdStudent() {
        return idStudent;
    }
}
