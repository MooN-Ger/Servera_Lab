package controllers;

import entities.Professor;
import requests.StringRequest;
import requests.professor.EditProfessorRequest;
import responses.CommonResponse;
import responses.EntityResponse;
import services.professor.ProfessorService;
import validator.request.StringRequestValidator;
import validator.request.professor.EditProfessorRequestValidator;

import java.util.List;

public class ProfessorController {

    private final ProfessorService professorService;
    private final EditProfessorRequestValidator editProfessorValidator;
    private final StringRequestValidator stringValidator;

    public ProfessorController(ProfessorService professorService,
                               EditProfessorRequestValidator editProfessorValidator,
                               StringRequestValidator stringValidator) {
        this.professorService = professorService;
        this.editProfessorValidator = editProfessorValidator;
        this.stringValidator = stringValidator;
    }

    public EntityResponse<CommonResponse<Void>> editProfessor(EditProfessorRequest request) {
        int status = 200;
        CommonResponse<Void> commonResponse;
        List<String> errors = editProfessorValidator.validate(request);
        if (errors.isEmpty()) {
            try {
                professorService.editProfessor(request.getProfessor());
                commonResponse = new CommonResponse<>(null);
            } catch (Exception e) {
                status = 400;
                commonResponse = new CommonResponse<>(2, e.getMessage());
            }
        }
        else {
            commonResponse = new CommonResponse<>(1, "Validation error", errors);
            status = 422;
        }
        return new EntityResponse<>(commonResponse, status);
    }

    public EntityResponse<CommonResponse<List<Professor>>> getProfessorsByPosition(StringRequest request) {
        int status = 200;
        CommonResponse<List<Professor>> commonResponse;
        List<String> errors = stringValidator.validate(request);
        if (errors.isEmpty()) {
            try {
                commonResponse = new CommonResponse<>(professorService.getProfessorsByPosition(request.getStr()));
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(2, e.getMessage());
            }
        } else {
            commonResponse = new CommonResponse<>(1, "Validation error", errors);
            status = 422;
        }
        return new EntityResponse<>(commonResponse, status);
    }
}
