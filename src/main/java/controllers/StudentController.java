package controllers;

import requests.IdRequest;
import requests.student.AddStudentRequest;
import requests.student.EditStudentRequest;
import responses.CommonResponse;
import responses.EntityResponse;
import responses.student.AddStudentResponse;
import responses.student.GetStudentByIdResponse;
import services.student.StudentService;
import validator.request.IdRequestValidator;
import validator.request.student.AddStudentRequestValidator;
import validator.request.student.EditStudentRequestValidator;

import java.util.List;

public class StudentController {
    private StudentService studentService;
    private AddStudentRequestValidator addStudentValidator;
    private EditStudentRequestValidator editStudentValidator;
    private IdRequestValidator idValidator;

    public StudentController(StudentService studentService, AddStudentRequestValidator addStudentValidator,
                             EditStudentRequestValidator editStudentValidator, IdRequestValidator idValidator) {
        this.studentService = studentService;
        this.addStudentValidator = addStudentValidator;
        this.editStudentValidator = editStudentValidator;
        this.idValidator = idValidator;
    }

    public EntityResponse<CommonResponse<AddStudentResponse>> addStudent(AddStudentRequest request) {
        int status = 201;
        CommonResponse<AddStudentResponse> commonResponse;
        List<String> errors = addStudentValidator.validate(request);
        if (errors.isEmpty()) {
            try {
                commonResponse = new CommonResponse<>(
                        new AddStudentResponse(studentService.addStudent(request.getName(), request.getSurname(), request.getPatronymic(), request.getStatus(), request.getGroupId())));
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(2, e.getMessage());
            }
        }
        else {
            commonResponse = new CommonResponse<>(1, "Validation error", errors);
            status = 422;
        }
        return new EntityResponse<>(commonResponse, status);
    }

    public EntityResponse<CommonResponse<Void>> editStudent(EditStudentRequest request) {
        int status = 200;
        CommonResponse<Void> commonResponse;
        List<String> errors = editStudentValidator.validate(request);
        if (errors.isEmpty()) {
            try {
                studentService.editStudent(request.getStudent());
                commonResponse = new CommonResponse<>(null);
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(2, e.getMessage());
            }
        }
        else {
            commonResponse = new CommonResponse<>(1, "Validation error", errors);
            status = 422;
        }
        return new EntityResponse<>(commonResponse, status);
    }

    public EntityResponse<CommonResponse<GetStudentByIdResponse>> getStudentById(IdRequest request) {
        int status = 200;
        CommonResponse<GetStudentByIdResponse> commonResponse;
        List<String> errors = idValidator.validate(request);
        if (errors.isEmpty()) {
            try {
                commonResponse = new CommonResponse<>(new GetStudentByIdResponse(studentService.getStudentById(request.getId())));
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(2, e.getMessage());
            }
        }
        else {
            commonResponse = new CommonResponse<>(1, "Validation error", errors);
            status = 422;
        }
        return new EntityResponse<>(commonResponse, status);
    }


}
