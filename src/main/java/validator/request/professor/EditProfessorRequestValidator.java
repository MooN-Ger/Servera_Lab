package validator.request.professor;

import requests.professor.EditProfessorRequest;
import requests.student.EditStudentRequest;
import validator.field.IdValidator;
import validator.field.StringValidator;
import validator.request.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditProfessorRequestValidator implements IRequestValidator<EditProfessorRequest> {
    private IdValidator idValidator;
    private StringValidator stringValidator;
    private static final int maxLength = 100;

    @Override
    public List<String> validate(EditProfessorRequest request) {
        List<String> errors = new ArrayList<>();

        idValidator.validateId(request.getProfessor().getId(), errors,
                "professorId", "Should be positive");
        stringValidator.validateStringNotEmpty(request.getProfessor().getName(), errors,
                "professorName", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getProfessor().getName(), maxLength, errors,
                "professorName", "Should be less than max length");
        stringValidator.validateStringNotEmpty(request.getProfessor().getSurname(), errors,
                "professorSurname", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getProfessor().getSurname(), maxLength, errors,
                "professorSurname", "Should be less than max length");
        stringValidator.validateStringNotEmpty(request.getProfessor().getPatronymic(), errors,
                "professorPatronymic", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getProfessor().getPatronymic(), maxLength, errors,
                "professorPatronymic", "Should be less than max length");
        stringValidator.validateStringNotEmpty(request.getProfessor().getPosition(), errors,
                "professorPosition", "Should be not Null and not Empty");
        stringValidator.validateStringMaxLength(request.getProfessor().getPosition(), maxLength, errors,
                "professorPosition", "Should be less than max length");

        return errors;
    }
}
