package responses;

public class EntityResponse<T> {
    private final T body;
    private final int httpStatus;

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
