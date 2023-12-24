package responses;

public class EntityResponse<T> {
    private T body;
    private int httpStatus;

    public EntityResponse(T body, int httpStatus) {
        this.body = body;
        this.httpStatus = httpStatus;
    }

    public T getBody() {
        return body;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
