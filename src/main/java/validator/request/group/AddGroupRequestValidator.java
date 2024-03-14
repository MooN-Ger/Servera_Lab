package validator.request.group;

import requests.group.AddGroupRequest;
import validator.field.StringValidator;
import validator.request.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddGroupRequestValidator implements IRequestValidator<AddGroupRequest> {
    private StringValidator stringValidator;
    private static final int maxLength = 100;

    @Override
    public List<String> validate(AddGroupRequest request) {
        List<String> errors = new ArrayList<>();

        stringValidator.validateStringNotEmpty(request.getName(), errors, "groupName", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getName(), maxLength, errors, "groupName", "Should be less than max length");

        return errors;
    }
}
