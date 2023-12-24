package validator.request.student;

import requests.student.AddStudentRequest;
import validator.field.IdValidator;
import validator.field.StringValidator;
import validator.request.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddStudentRequestValidator implements IRequestValidator<AddStudentRequest> {
    private IdValidator idValidator;
    private StringValidator stringValidator;
    private static final int maxLength = 100;
    @Override
    public List<String> validate(AddStudentRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.validateId(request.getGroupId(), errors, "groupId", "Should be positive");
        stringValidator.validateStringNotEmpty(request.getName(), errors, "studentName", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getName(), maxLength, errors, "studentName", "Should be less than max length");
        stringValidator.validateStringNotEmpty(request.getSurname(), errors, "studentSurname", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getSurname(), maxLength, errors, "studentSurname", "Should be less than max length");
        stringValidator.validateStringNotEmpty(request.getPatronymic(), errors, "studentPatronymic", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getPatronymic(), maxLength, errors, "studentPatronymic", "Should be less than max length");

        return errors;
    }
}
