package validator.request;

import java.util.List;

public interface IRequestValidator<T> {
    List<String> validate(T request);
}
