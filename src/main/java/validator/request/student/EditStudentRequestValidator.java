package validator.request.student;

import requests.student.EditStudentRequest;
import validator.field.IdValidator;
import validator.field.StringValidator;
import validator.request.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentRequestValidator implements IRequestValidator<EditStudentRequest> {
    private IdValidator idValidator;
    private StringValidator stringValidator;
    private static final int maxLength = 100;

    @Override
    public List<String> validate(EditStudentRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.validateId(request.getStudent().getId(), errors, "studentId", "Should be positive");
        idValidator.validateId(request.getStudent().getGroupId(), errors, "groupId", "Should be positive");
        stringValidator.validateStringNotEmpty(request.getStudent().getName(), errors, "studentName", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getStudent().getName(), maxLength, errors, "studentName", "Should be less than max length");
        stringValidator.validateStringNotEmpty(request.getStudent().getSurname(), errors, "studentSurname", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getStudent().getSurname(), maxLength, errors, "studentSurname", "Should be less than max length");
        stringValidator.validateStringNotEmpty(request.getStudent().getPatronymic(), errors, "studentPatronymic", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getStudent().getPatronymic(), maxLength, errors, "studentPatronymic", "Should be less than max length");
        
        return errors;
    }
}
