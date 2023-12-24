package responses;

import java.util.List;

public class CommonResponse<T> {
    private boolean isOk;
    private int errorCode;
    private String errorMessage;
    private List<String> errors;
    private T data;

    public CommonResponse(T data) {
        this.data = data;
        isOk = true;
        errorCode = 0;
        errorMessage = null;
        errors = null;
    }

    public CommonResponse(int errorCode, String errorMessage) {
        data = null;
        isOk = false;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errors = null;
    }

    public CommonResponse(int errorCode, String errorMessage, List<String> errors) {
        data = null;
        isOk = false;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errors = errors;
    }

    public boolean isOk() {
        return isOk;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<String> getErrors() {
        return errors;
    }

    public T getData() {
        return data;
    }
}
