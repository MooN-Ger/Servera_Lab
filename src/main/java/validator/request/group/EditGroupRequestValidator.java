package validator.request.group;

import requests.group.EditGroupRequest;
import validator.field.IdValidator;
import validator.field.StringValidator;
import validator.request.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditGroupRequestValidator implements IRequestValidator<EditGroupRequest> {
    private IdValidator idValidator;
    private StringValidator stringValidator;
    private static final int maxLength = 100;

    @Override
    public List<String> validate(EditGroupRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.validateId(request.getGroup().getId(), errors, "groupId", "Should be positive");
        stringValidator.validateStringNotEmpty(request.getGroup().getName(), errors, "groupName", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getGroup().getName(), maxLength, errors, "groupName", "Should be less than max length");

        return errors;
    }
}
