package validator.request;

import requests.IdRequest;
import validator.field.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class IdRequestValidator implements IRequestValidator<IdRequest> {
    private IdValidator idValidator;

    @Override
    public List<String> validate(IdRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.validateId(request.getId(), errors, "Id", "Should be positive");

        return errors;
    }
}
