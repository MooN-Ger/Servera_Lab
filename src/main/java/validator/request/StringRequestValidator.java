package validator.request;

import requests.IdRequest;
import requests.StringRequest;
import validator.field.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class StringRequestValidator implements IRequestValidator<StringRequest> {
    private StringValidator strValidator;
    private static final int maxLength = 100;

    @Override
    public List<String> validate(StringRequest request) {
        List<String> errors = new ArrayList<>();

        strValidator.validateStringNotEmpty(request.getStr(), errors,
                "String", "Should be not Null and not Empty");
        strValidator.validateStringMaxLength(request.getStr(), maxLength, errors,
                "String", "Should be less than max length");

        return errors;
    }
}
